pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    sh 'terraform version'
                }
            }
        }
    }

}
