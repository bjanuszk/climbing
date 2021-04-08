pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('terraformdocker/terraform:latest') {
                    echo 'building'
                }
            }
        }
    }

}
