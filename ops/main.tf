provider "aws" {
  region = "eu-west-1"
}

data "template_file" "policy" {
  template = "${file("/policies/servicepolicy.json")}"
}

module "IAM" {
  source = "git::https://bitbucket.org/morrisonsplc/loyalty-school-registration.git//ops/infrastructure/modules/IAM?ref=master"
  application_service = "service"
  owner_name = "BJ"
  environment = "test"
  seq_id = 1
  policy = data.template_file.policy.rendered
}
