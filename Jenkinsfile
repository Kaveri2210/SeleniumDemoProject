pipeline {
    agent any

    tools {
        jdk 'JDK17'          // Name of your JDK in Jenkins Global Tool Config
        maven 'Maven3.9.9'   // Name of your Maven install in Jenkins
    }

    environment {
        BROWSER = 'chrome' // Default browser
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
                sh 'mvn clean compile'
            }
        }

        stage('Test - Chrome') {
            steps {
                echo 'Running tests on Chrome...'
                script {
                    env.BROWSER = 'chrome'
                    sh "mvn test -Dbrowser=${env.BROWSER}"
                }
            }
        }

        stage('Test - Firefox') {
            steps {
                echo 'Running tests on Firefox...'
                script {
                    env.BROWSER = 'firefox'
                    sh "mvn test -Dbrowser=${env.BROWSER}"
                }
            }
        }

        stage('Test - Edge') {
            steps {
                echo 'Running tests on Edge...'
                script {
                    env.BROWSER = 'edge'
                    sh "mvn test -Dbrowser=${env.BROWSER}"
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
