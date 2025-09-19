# Spring Web Services EKS Deployment Guide

This guide provides comprehensive instructions for deploying the Spring Web Services application to Amazon EKS using Terraform and Ansible.

## 🏗️ Architecture Overview

The deployment creates:
- **EKS Cluster**: Managed Kubernetes cluster
- **VPC**: Custom VPC with public and private subnets
- **Node Groups**: Auto-scaling worker nodes
- **PostgreSQL**: Database using Bitnami Helm chart
- **Spring Boot App**: REST API, gRPC, and Actuator services
- **Load Balancer**: AWS Load Balancer Controller
- **Monitoring**: Cluster Autoscaler and Metrics Server

## 📋 Prerequisites

### Required Tools
- **AWS CLI** (v2.x)
- **Terraform** (v1.0+)
- **kubectl** (v1.28+)
- **Helm** (v3.x)
- **Ansible** (v2.9+)
- **Docker** (for building images)

### AWS Requirements
- AWS Account with appropriate permissions
- AWS CLI configured with credentials
- Sufficient AWS service limits for EKS resources

### Install Prerequisites

#### Ubuntu/Debian
```bash
# AWS CLI
curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
unzip awscliv2.zip
sudo ./aws/install

# Terraform
wget https://releases.hashicorp.com/terraform/1.6.0/terraform_1.6.0_linux_amd64.zip
unzip terraform_1.6.0_linux_amd64.zip
sudo mv terraform /usr/local/bin/

# kubectl
curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl"
sudo install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl

# Helm
curl https://raw.githubusercontent.com/helm/helm/main/scripts/get-helm-3 | bash

# Ansible
sudo apt update
sudo apt install ansible python3-pip -y
pip3 install kubernetes
```

#### macOS
```bash
# Using Homebrew
brew install awscli terraform kubectl helm ansible
pip3 install kubernetes
```

## 🚀 Quick Start

### 1. Configure AWS Credentials
```bash
aws configure
# Enter your AWS Access Key ID, Secret Access Key, and region
```

### 2. Build and Push Docker Image
```bash
# Build the application image
docker build -t spring-webservices-backend:latest ./backend

# Tag for your registry
docker tag spring-webservices-backend:latest marouanedbibih/spring-webservices-backend:latest

# Push to registry
docker push marouanedbibih/spring-webservices-backend:latest
```

### 3. Deploy Everything
```bash
# Make the deployment script executable
chmod +x deploy.sh

# Deploy with default settings
./deploy.sh

# Or deploy with custom settings
./deploy.sh --region us-east-1 --environment prod --tag v1.0.0
```

## 📁 Project Structure

```
spring-webservices/
├── terraform/                 # Infrastructure as Code
│   ├── main.tf               # Main Terraform configuration
│   ├── variables.tf           # Variable definitions
│   ├── vpc.tf                # VPC and networking
│   ├── security-groups.tf     # Security groups
│   ├── iam.tf                # IAM roles and policies
│   ├── eks.tf                # EKS cluster and node groups
│   ├── outputs.tf             # Output values
│   └── terraform.tfvars.example
├── ansible/                   # Application deployment
│   ├── requirements.yml       # Ansible collections
│   ├── inventory.yml          # Inventory file
│   ├── group_vars/all.yml     # Global variables
│   └── playbooks/             # Deployment playbooks
│       ├── deploy.yml         # Deploy application
│       ├── uninstall.yml      # Uninstall application
│       └── status.yml         # Check status
├── helm/                      # Helm chart
│   ├── Chart.yaml            # Chart metadata
│   ├── values.yaml           # Default values
│   ├── templates/            # Kubernetes templates
│   └── README.md             # Helm chart documentation
└── deploy.sh                 # Main deployment script
```

## ⚙️ Configuration

### Terraform Variables

Create `terraform/terraform.tfvars`:
```hcl
aws_region = "us-west-2"
project_name = "spring-webservices"
environment = "dev"
cluster_version = "1.28"
node_instance_types = ["t3.medium"]
node_desired_size = 2
node_min_size = 1
node_max_size = 4
```

### Ansible Variables

Modify `ansible/group_vars/all.yml`:
```yaml
aws_region: "us-west-2"
cluster_name: "spring-webservices-dev-eks"
helm_namespace: "spring-webservices"
docker_image_repository: "marouanedbibih/spring-webservices-backend"
docker_image_tag: "latest"
```

### Helm Values

Update `helm/values.yaml`:
```yaml
image:
  repository: "marouanedbibih/spring-webservices-backend"
  tag: "latest"

service:
  type: NodePort
  port: 8080
  nodePort: 30080
```

## 🔧 Manual Deployment Steps

### 1. Deploy Infrastructure
```bash
cd terraform
terraform init
terraform plan
terraform apply
```

### 2. Configure kubectl
```bash
aws eks update-kubeconfig --region us-west-2 --name spring-webservices-dev-eks
```

### 3. Deploy Application
```bash
cd ansible
ansible-galaxy collection install -r requirements.yml
ansible-playbook -i inventory.yml playbooks/deploy.yml
```

## 🌐 Accessing the Application

After deployment, access your services:

### REST API
```bash
# Get node IP
NODE_IP=$(kubectl get nodes -o jsonpath="{.items[0].status.addresses[0].address}")

# Access REST API
curl http://$NODE_IP:30080/api/health
```

### Swagger UI
```
http://<NODE_IP>:30080/swagger-ui.html
```

### GraphiQL Playground
```
http://<NODE_IP>:30080/graphiql
```

### Spring Boot Actuator
```bash
curl http://$NODE_IP:30091/actuator/health
curl http://$NODE_IP:30091/actuator/metrics
```

### gRPC Service
```bash
# Test gRPC connection
grpcurl -plaintext $NODE_IP:30090 list
```

## 📊 Monitoring and Management

### Check Application Status
```bash
./deploy.sh --action status
```

### View Logs
```bash
kubectl logs -f deployment/spring-webservices -n spring-webservices
kubectl logs -f deployment/spring-webservices-postgresql -n spring-webservices
```

### Scale Application
```bash
kubectl scale deployment spring-webservices --replicas=3 -n spring-webservices
```

### Access Database
```bash
kubectl exec -it deployment/spring-webservices-postgresql -n spring-webservices -- psql -U postgres -d backend
```

## 🔄 Updates and Maintenance

### Update Application
```bash
# Build new image
docker build -t spring-webservices-backend:v1.1.0 ./backend
docker push marouanedbibih/spring-webservices-backend:v1.1.0

# Deploy with new tag
./deploy.sh --tag v1.1.0
```

### Update Infrastructure
```bash
cd terraform
terraform plan
terraform apply
```

## 🗑️ Cleanup

### Uninstall Application
```bash
./deploy.sh --action destroy
```

### Manual Cleanup
```bash
# Uninstall Helm release
helm uninstall spring-webservices -n spring-webservices

# Delete namespace
kubectl delete namespace spring-webservices

# Destroy infrastructure
cd terraform
terraform destroy
```

## 🐛 Troubleshooting

### Common Issues

#### 1. AWS Credentials Not Configured
```bash
aws configure
# Or set environment variables
export AWS_ACCESS_KEY_ID=your_key
export AWS_SECRET_ACCESS_KEY=your_secret
```

#### 2. kubectl Connection Issues
```bash
aws eks update-kubeconfig --region us-west-2 --name spring-webservices-dev-eks
kubectl get nodes
```

#### 3. Pod Not Starting
```bash
kubectl describe pod <pod-name> -n spring-webservices
kubectl logs <pod-name> -n spring-webservices
```

#### 4. Database Connection Issues
```bash
kubectl get pods -n spring-webservices
kubectl exec -it <postgresql-pod> -n spring-webservices -- psql -U postgres -d backend
```

#### 5. Service Not Accessible
```bash
kubectl get services -n spring-webservices
kubectl get nodes -o wide
```

### Debug Commands
```bash
# Check cluster status
kubectl cluster-info

# Check node status
kubectl get nodes

# Check all resources
kubectl get all -n spring-webservices

# Check events
kubectl get events -n spring-webservices --sort-by='.lastTimestamp'
```

## 📈 Scaling and Performance

### Horizontal Pod Autoscaling
```bash
kubectl autoscale deployment spring-webservices --cpu-percent=70 --min=2 --max=10 -n spring-webservices
```

### Cluster Autoscaling
The cluster autoscaler is automatically configured to scale nodes based on demand.

### Resource Optimization
Adjust resource limits in `helm/values.yaml`:
```yaml
backend:
  resources:
    limits:
      cpu: "1000m"
      memory: "1Gi"
    requests:
      cpu: "500m"
      memory: "512Mi"
```

## 🔒 Security Considerations

### Network Security
- Private subnets for worker nodes
- Security groups with minimal required access
- VPC endpoints for AWS services

### Application Security
- Non-root containers
- Resource limits and requests
- Health checks and readiness probes

### Database Security
- Encrypted storage
- Network isolation
- Access controls

## 📚 Additional Resources

- [EKS Documentation](https://docs.aws.amazon.com/eks/)
- [Terraform AWS Provider](https://registry.terraform.io/providers/hashicorp/aws/latest/docs)
- [Ansible Kubernetes Collection](https://docs.ansible.com/ansible/latest/collections/kubernetes/core/)
- [Helm Documentation](https://helm.sh/docs/)
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)

## 🤝 Support

For issues and questions:
1. Check the troubleshooting section
2. Review logs and events
3. Consult the documentation
4. Create an issue in the repository
