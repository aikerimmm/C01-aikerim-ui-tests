pipeline {
    agent any

    stages {
        stage('Run Tests') {
            steps {
                sh './gradlew clean test'
            }
        }

        stage('Generate Allure Report') {
            steps {
                sh '/opt/homebrew/bin/allure generate build/allure-results --clean -o build/allure-report'
            }
        }
    }

    post {
        always {
            sh 'java -DconfigFile=notifications/config.json -jar notifications/allure-notifications-4.11.0.jar'
        }
    }
}