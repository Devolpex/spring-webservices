#!/bin/bash

# Spring Web Services EKS Deployment Script
# This script deploys the Spring Web Services application to AWS EKS using Terraform and Ansible

set -e

# Colors for output
RED='\033[0;31m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

# Default values
AWS_REGION="us-west-2"
PROJECT_NAME="spring-webservices"
ENVIRONMENT="dev"
DOCKER_REGISTRY="marouanedbibih"
IMAGE_TAG="latest"
ACTION="deploy"

# Function to print colored output
print_status() {
    echo -e "${BLUE}[INFO]${NC} $1"
}

print_success() {
    echo -e "${GREEN}[SUCCESS]${NC} $1"
}

print_warning() {
    echo -e "${YELLOW}[WARNING]${NC} $1"
}

print_error() {
    echo -e "${RED}[ERROR]${NC} $1"
}

# Function to show usage
show_usage() {
    echo "Usage: $0 [OPTIONS]"
    echo ""
    echo "Options:"
    echo "  -r, --region REGION        AWS region (default: us-west-2)"
    echo "  -p, --project PROJECT      Project name (default: spring-webservices)"
    echo "  -e, --environment ENV      Environment (default: dev)"
    echo "  -d, --docker-registry REG   Docker registry (default: marouanedbibih)"
    echo "  -t, --tag TAG              Docker image tag (default: latest)"
    echo "  -a, --action ACTION        Action: deploy, destroy, status (default: deploy)"
    echo "  -h, --help                Show this help message"
    echo ""
    echo "Examples:"
    echo "  $0 --deploy"
    echo "  $0 --action destroy"
    echo "  $0 --region us-east-1 --environment prod"
}

# Parse command line arguments
while [[ $# -gt 0 ]]; do
    case $1 in
        -r|--region)
            AWS_REGION="$2"
            shift 2
            ;;
        -p|--project)
            PROJECT_NAME="$2"
            shift 2
            ;;
        -e|--environment)
            ENVIRONMENT="$2"
            shift 2
            ;;
        -d|--docker-registry)
            DOCKER_REGISTRY="$2"
            shift 2
            ;;
        -t|--tag)
            IMAGE_TAG="$2"
            shift 2
            ;;
        -a|--action)
            ACTION="$2"
            shift 2
            ;;
        -h|--help)
            show_usage
            exit 0
            ;;
        *)
            print_error "Unknown option: $1"
            show_usage
            exit 1
            ;;
    esac
done

# Validate action
if [[ ! "$ACTION" =~ ^(deploy|destroy|status)$ ]]; then
    print_error "Invalid action: $ACTION. Must be one of: deploy, destroy, status"
    exit 1
fi

# Set cluster name
CLUSTER_NAME="${PROJECT_NAME}-${ENVIRONMENT}-eks"

print_status "Starting Spring Web Services EKS deployment"
print_status "Region: $AWS_REGION"
print_status "Project: $PROJECT_NAME"
print_status "Environment: $ENVIRONMENT"
print_status "Cluster: $CLUSTER_NAME"
print_status "Docker Registry: $DOCKER_REGISTRY"
print_status "Image Tag: $IMAGE_TAG"
print_status "Action: $ACTION"

# Check prerequisites
check_prerequisites() {
    print_status "Checking prerequisites..."
    
    # Check AWS CLI
    if ! command -v aws &> /dev/null; then
        print_error "AWS CLI is not installed. Please install it first."
        exit 1
    fi
    
    # Check Terraform
    if ! command -v terraform &> /dev/null; then
        print_error "Terraform is not installed. Please install it first."
        exit 1
    fi
    
    # Check kubectl
    if ! command -v kubectl &> /dev/null; then
        print_error "kubectl is not installed. Please install it first."
        exit 1
    fi
    
    # Check Helm
    if ! command -v helm &> /dev/null; then
        print_error "Helm is not installed. Please install it first."
        exit 1
    fi
    
    # Check Ansible
    if ! command -v ansible-playbook &> /dev/null; then
        print_error "Ansible is not installed. Please install it first."
        exit 1
    fi
    
    # Check AWS credentials
    if ! aws sts get-caller-identity &> /dev/null; then
        print_error "AWS credentials not configured. Please run 'aws configure' first."
        exit 1
    fi
    
    print_success "All prerequisites are met"
}

# Deploy infrastructure
deploy_infrastructure() {
    print_status "Deploying EKS infrastructure with Terraform..."
    
    cd terraform
    
    # Initialize Terraform
    terraform init
    
    # Create terraform.tfvars
    cat > terraform.tfvars << EOF
aws_region = "$AWS_REGION"
project_name = "$PROJECT_NAME"
environment = "$ENVIRONMENT"
EOF
    
    # Plan and apply
    terraform plan -out=tfplan
    terraform apply tfplan
    
    print_success "EKS infrastructure deployed successfully"
    
    cd ..
}

# Destroy infrastructure
destroy_infrastructure() {
    print_status "Destroying EKS infrastructure with Terraform..."
    
    cd terraform
    
    # Initialize Terraform if not already done
    terraform init
    
    # Destroy
    terraform destroy -auto-approve
    
    print_success "EKS infrastructure destroyed successfully"
    
    cd ..
}

# Deploy application
deploy_application() {
    print_status "Deploying Spring Web Services application with Ansible..."
    
    cd ansible
    
    # Install Ansible requirements
    ansible-galaxy collection install -r requirements.yml
    
    # Run deployment playbook
    ansible-playbook -i inventory.yml playbooks/deploy.yml \
        -e "aws_region=$AWS_REGION" \
        -e "project_name=$PROJECT_NAME" \
        -e "environment=$ENVIRONMENT" \
        -e "cluster_name=$CLUSTER_NAME" \
        -e "docker_registry=$DOCKER_REGISTRY" \
        -e "image_tag=$IMAGE_TAG"
    
    print_success "Spring Web Services application deployed successfully"
    
    cd ..
}

# Check application status
check_status() {
    print_status "Checking Spring Web Services status..."
    
    cd ansible
    
    # Run status playbook
    ansible-playbook -i inventory.yml playbooks/status.yml \
        -e "aws_region=$AWS_REGION" \
        -e "project_name=$PROJECT_NAME" \
        -e "environment=$ENVIRONMENT" \
        -e "cluster_name=$CLUSTER_NAME"
    
    cd ..
}

# Uninstall application
uninstall_application() {
    print_status "Uninstalling Spring Web Services application..."
    
    cd ansible
    
    # Run uninstall playbook
    ansible-playbook -i inventory.yml playbooks/uninstall.yml \
        -e "aws_region=$AWS_REGION" \
        -e "project_name=$PROJECT_NAME" \
        -e "environment=$ENVIRONMENT" \
        -e "cluster_name=$CLUSTER_NAME"
    
    print_success "Spring Web Services application uninstalled successfully"
    
    cd ..
}

# Main execution
main() {
    check_prerequisites
    
    case $ACTION in
        deploy)
            deploy_infrastructure
            deploy_application
            print_success "Deployment completed successfully!"
            print_status "You can now access your application using the URLs shown above."
            ;;
        destroy)
            uninstall_application
            destroy_infrastructure
            print_success "Destruction completed successfully!"
            ;;
        status)
            check_status
            ;;
    esac
}

# Run main function
main
