pipeline {
    agent any
    environment {
        GLOBAL = "glob"
    }
    stages {
        stage('Build') {
            steps {
                withDockerContainer('7factor/terraform-resource:latest') {
                    script {
                        sh 'terraform version'
                        dir("ops") {
                            sh 'terraform init'
//                            env.TERRAFORM_PLAN_EXIT_CODE = sh(returnStatus: true, script: "terraform plan -no-color -detailed-exitcode")
                        }

//                        timeout(time: 30, unit: 'SECONDS') {
//                            sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
//                            input message: 'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
//                        }
                        timeout(time: 30, unit: 'SECONDS') {
                            sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
                            input message: 'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
                        }

                        try {
                            dir("ops") {
                                sh 'printenv'
                                sh 'terraform apply -auto-approve'
                                sh 'cat ./myfile.txt'
                            }
                        }
                        catch (e) {
                            sh 'echo dupa ${e}'
                            throw e
                        }
                    }
                }
            }
        }
    }
}
