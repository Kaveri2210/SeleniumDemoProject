pipeline {
    agent any

    tools {
        jdk 'JDK17'
        maven 'Maven3.9.9'
    }

    environment {
        BROWSER = 'chrome'
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Checking out code from GitHub...'
                git branch: 'main', url: 'https://github.com/Kaveri2210/SeleniumDemoProject.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project with Maven...'
                bat 'mvn clean compile'
            }
        }

        stage('Test - Chrome') {
            steps {
                echo 'Running tests on Chrome...'
                script {
                    env.BROWSER = 'chrome'
                    bat "mvn test -Dbrowser=%BROWSER%"
                }
            }
        }

        stage('Test - Firefox') {
            steps {
                echo 'Running tests on Firefox...'
                script {
                    env.BROWSER = 'firefox'
                    bat "mvn test -Dbrowser=%BROWSER%"
                }
            }
        }

        stage('Test - Edge') {
            steps {
                echo 'Running tests on Edge...'
                script {
                    env.BROWSER = 'edge'
                    bat "mvn test -Dbrowser=%BROWSER%"
                }
            }
        }
    }

    post {
        always {
            echo 'Cleaning up workspace...'
            cleanWs()
        }
        success {
            echo 'Pipeline finished successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the console output.'
        }
    }
}
