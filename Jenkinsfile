pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    sh 'terraform version'
                    dir("ops") {
                        sh 'terraform init'
                        sh 'terraform plan -no-color'
                    }
                    timeout(time:30, unit:'SECONDS') {
                        sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
                        input message:'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
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
