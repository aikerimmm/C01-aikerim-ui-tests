pipeline {
    agent any

    stages {
        stage('Run Tests') {
            steps {
                sh './gradlew clean test || true'
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh './gradlew allureReport || true'
            }
        }
    }

    post {
        always {
            sh 'java -DconfigFile=notifications/config.json -jar notifications/allure-notifications-4.11.0.jar'
        }
    }
}