pipeline {
    agent any

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
                java -jar notifications/allure-notifications-4.11.0.jar \
                    notifications/config.json \
                    -token \${TELEGRAM_BOT_TOKEN} \
                    -chat \${TELEGRAM_CHAT_ID}
            """
        }
    }
}