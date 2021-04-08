pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('hashicorp/terraform:light') {
                    echo 'building'
                }
            }
        }
    }

}
