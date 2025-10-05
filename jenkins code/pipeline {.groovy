pipeline {
    agent any

    environment {
        DIRECTORY_PATH = '/path/to/source/code'      // change this to your folder
        TESTING_ENVIRONMENT = 'Testing_Server_01'
        PRODUCTION_ENVIRONMENT = 'GursimerKaur'      // use your name
    }

    stages {
        stage('Build') {
            steps {
                echo "Fetch the source code from the directory path specified by the environment variable: ${DIRECTORY_PATH}"
                echo "Compile the code and generate any necessary artefacts"
            }
        }

        stage('Test') {
            steps {
                echo "Running Unit tests"
                echo "Running Integration tests"
            }
        }

        stage('Code Quality Check') {
            steps {
                echo "Check the quality of the code"
            }
        }

        stage('Deploy') {
            steps {
                echo "Deploy the application to a testing environment specified by the environment variable: ${TESTING_ENVIRONMENT}"
            }
        }

        stage('Approval') {
            steps {
                echo "Waiting for manual approval..."
                sleep(time: 10, unit: 'SECONDS')
            }
        }

        stage('Deploy to Production') {
            steps {
                echo "Deploy the code to the production environment: ${PRODUCTION_ENVIRONMENT}"
            }
        }
    }
}
