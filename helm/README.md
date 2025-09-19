# Spring Web Services Helm Chart

This Helm chart deploys a Spring Boot Web Services application with PostgreSQL database using Bitnami's PostgreSQL chart.

## Prerequisites

- Kubernetes 1.19+
- Helm 3.2.0+
- Docker image of the Spring Boot application

## Features

- Spring Boot REST API on port 8080
- gRPC service on port 9000
- Spring Boot Actuator on port 8090
- PostgreSQL database with persistent storage
- NodePort service exposure for external access
- Health checks and readiness probes
- Configurable resource limits and requests

## Installation

### 1. Build and Push Docker Image

First, build your Spring Boot application Docker image:

```bash
# Build the Docker image
docker build -t spring-webservices-backend:latest ./backend

# Tag for your registry (replace with your registry)
docker tag spring-webservices-backend:latest your-registry/spring-webservices-backend:latest

# Push to registry
docker push your-registry/spring-webservices-backend:latest
```

### 2. Update Image Repository

Update the `values.yaml` file to point to your Docker image:

```yaml
image:
  repository: your-registry/spring-webservices-backend
  tag: latest
```

### 3. Install Dependencies

```bash
helm dependency update
```

### 4. Deploy the Chart

```bash
# Install with default values
helm install spring-webservices ./

# Or install with custom values
helm install spring-webservices ./ -f custom-values.yaml
```

## Configuration

### Service Ports

The application exposes three services via NodePort:

- **REST API**: NodePort 30080 (HTTP)
- **gRPC Service**: NodePort 30090
- **Actuator**: NodePort 30091 (Health checks, metrics)

### Database Configuration

PostgreSQL is configured with:
- Database: `backend`
- Username: `postgres`
- Password: `postgres`
- Persistent storage: 8Gi

### Environment Variables

Key environment variables:
- `SPRING_PROFILES_ACTIVE`: Set to "dev"
- `DB_URL`: Automatically configured to point to PostgreSQL service
- `DB_USER`: PostgreSQL username
- `DB_PASSWORD`: PostgreSQL password
- `CORS_ALLOWED_ORIGINS`: Set to "*" for development

## Accessing the Application

After deployment, you can access the services:

```bash
# Get the node IP
export NODE_IP=$(kubectl get nodes -o jsonpath="{.items[0].status.addresses[0].address}")

# REST API
curl http://$NODE_IP:30080/api/health

# Swagger UI
open http://$NODE_IP:30080/swagger-ui.html

# GraphiQL Playground
open http://$NODE_IP:30080/graphiql

# Actuator Health
curl http://$NODE_IP:30091/actuator/health
```

## Customization

### Resource Limits

Update resource limits in `values.yaml`:

```yaml
backend:
  resources:
    limits:
      cpu: 1000m
      memory: 1Gi
    requests:
      cpu: 500m
      memory: 512Mi
```

### Database Configuration

Modify PostgreSQL settings:

```yaml
postgresql:
  auth:
    postgresPassword: "your-secure-password"
    username: "your-username"
    password: "your-password"
    database: "your-database"
  primary:
    persistence:
      size: 20Gi
```

### Service Type

Change from NodePort to LoadBalancer or ClusterIP:

```yaml
service:
  type: LoadBalancer
  # Remove nodePort configurations when using LoadBalancer
```

## Monitoring

The application includes Spring Boot Actuator endpoints for monitoring:

- Health checks: `/actuator/health`
- Metrics: `/actuator/metrics`
- Prometheus metrics: `/actuator/prometheus`

## Troubleshooting

### Check Pod Status

```bash
kubectl get pods
kubectl describe pod <pod-name>
kubectl logs <pod-name>
```

### Check Service Status

```bash
kubectl get services
kubectl describe service <service-name>
```

### Check Database Connection

```bash
kubectl exec -it <postgresql-pod> -- psql -U postgres -d backend
```

## Uninstallation

```bash
helm uninstall spring-webservices
```

## Development

### Local Testing

For local development, you can use port-forwarding:

```bash
# Forward REST API
kubectl port-forward svc/spring-webservices 8080:8080

# Forward gRPC
kubectl port-forward svc/spring-webservices 9000:9000

# Forward Actuator
kubectl port-forward svc/spring-webservices 8090:8090
```
