pipeline {
    agent any

    tools {
        maven 'Maven3'    // Make sure Maven3 is configured in Jenkins (Manage Jenkins → Global Tool Configuration)
        jdk 'JDK11'       // Or whichever JDK you installed
    }

    environment {
        BROWSER = "chrome"   // Default browser for test
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Fetching latest code...'
                git branch: 'main', url: 'https://github.com/<your-username>/SeleniumDemoProject.git'
            }
        }

        stage('Build') {
            steps {
                echo 'Building project with Maven...'
                sh 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Selenium tests on ${BROWSER}..."
                sh 'mvn test -DsuiteXmlFile=testng.xml'
            }
        }

        stage('Archive Results') {
            steps {
                echo 'Archiving reports...'
                archiveArtifacts artifacts: 'target/surefire-reports/**/*.*', allowEmptyArchive: true
                junit 'target/surefire-reports/*.xml'
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo '✅ Tests Passed Successfully!'
        }
        failure {
            echo '❌ Tests Failed. Check Reports!'
        }
    }
}
