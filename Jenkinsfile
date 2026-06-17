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
                sh '/opt/homebrew/bin/allure generate build/allure-results --clean -o build/allure-report'
            }
        }
    }

    post {
        always {
            sh 'java -DconfigFile=notifications/config.json -jar notifications/allure-notifications-4.2.1.jar'
        }
    }
}