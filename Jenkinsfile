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
                sh './gradlew allureReport'
            }
        }
    }

    post {
        always {
            sh 'java -DconfigFile=notifications/config.json -jar notifications/allure-notifications-4.2.1.jar'
        }
    }
}