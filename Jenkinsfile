pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('terraformers/docker-tnz:latest') {
                    sh 'terraform version'
                }
            }
        }
    }

}
