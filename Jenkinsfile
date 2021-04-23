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
                            env.TERRAFORM_PLAN_EXIT_CODE = sh(returnStatus: true, script: "terraform plan -no-color -detailed-exitcode")
                            sh 'printenv'
                        }

                        if (env.TERRAFORM_PLAN_EXIT_CODE == '2') {
                            timeout(time: 30, unit: 'SECONDS') {
                                sh 'echo Users allowed to approve: ${TERRAFORM_APPROVERS}'
                                input message: 'Approve deployment?', submitter: "${TERRAFORM_APPROVERS}"
                            }
                            dir("ops") {
                                sh 'terraform apply -auto-approve'
                                sh 'cat ./myfile.txt'
                            }
                        } else if (env.TERRAFORM_PLAN_EXIT_CODE == '0') {
                            sh 'echo "There are no infrastructure changes"'
                        }
                    }
                }
            }
        }
    }
}
