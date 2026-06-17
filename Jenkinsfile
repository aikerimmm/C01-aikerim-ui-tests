pipeline {
    agent any

    environment {
        TELEGRAM_BOT_TOKEN = credentials('TELEGRAM_BOT_TOKEN')
        TELEGRAM_CHAT_ID = credentials('TELEGRAM_CHAT_ID')
    }

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
            sh """
                java -DconfigFile=notifications/config.json \\
                    -Dnotifications.telegram.token=${TELEGRAM_BOT_TOKEN} \\
                    -Dnotifications.telegram.chat=${TELEGRAM_CHAT_ID} \\
                    -jar notifications/allure-notifications-3.1.1.jar
            """
        }
    }
}