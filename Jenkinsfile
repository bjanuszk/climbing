pipeline {
    agent any
    stages {
        stage('Init') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    sh 'terraform version'
                    dir("ops") {
                        sh 'terraform init'
                    }
                }
            }
        }
        stage('Plan'){
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    dir("ops") {
                        sh 'terraform plan -no-color'
                    }
                }
            }
        }
        stage('Approve'){
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    timeout(time:30, unit:'SECONDS') {
                        sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
                        input message:'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
                    }
                }
            }
        }
        stage('Apply'){
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    dir("ops") {
                        sh 'terraform apply -auto-approve'
                        sh 'cat ./myfile.txt'
                    }
                }
            }
        }
    }
}
