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
    }

    post {
        always {
            sh """
                java \
                    -DconfigFile=notifications/config.json \
                    -jar notifications/allure-notifications-4.11.0.jar \
                    -token ${TELEGRAM_BOT_TOKEN} \
                    -chat ${TELEGRAM_CHAT_ID}
            """
        }
    }
}