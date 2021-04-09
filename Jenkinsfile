pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    sh 'terraform version'
                    dir("ops") {
                        sh 'terraform init'
                        sh 'terraform plan'
                        echo '${TERRAFORM_APPROVERS}'
                    }
                    timeout(time:30, unit:'SECONDS') {
                        input message:'Approve deployment?'
                    }
                    dir("ops") {
                        sh 'terraform apply -auto-approve'
                        sh 'cat ./myfile.txt'
                    }
                }
            }
        }
    }
}
