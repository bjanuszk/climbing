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
                        sh 'echo ${TERRAFORM_APPROVERS}'
                    }
                    timeout(time:30, unit:'SECONDS') {
                        input message:'Approve deployment?', submitter: ${TERRAFORM_APPROVERS}
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
