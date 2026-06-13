# Event-Driven Microservice System

## Overview

This project demonstrates an Event-Driven Microservice Architecture built using Spring Boot and Apache Kafka.

The system consists of multiple independent microservices that communicate asynchronously through Kafka events.

## Architecture

Order Service → Kafka → Payment Service → Kafka → Inventory Service → Kafka → Analytics Service

## Features

* Event-driven communication
* Apache Kafka messaging
* Spring Boot microservices
* Loose coupling between services
* Scalable architecture
* Asynchronous processing

## Tech Stack

* Java 17
* Spring Boot
* Apache Kafka
* Maven
* Docker
* REST APIs

## Services

### Order Service

* Creates orders
* Publishes OrderCreated events

### Payment Service

* Consumes order events
* Processes payments
* Publishes PaymentCompleted events

### Inventory Service

* Updates inventory after successful payment

### Analytics Service

* Tracks business events
* Generates analytics data

## Project Structure

Event-Driven-Microservice-System

├── OrderService
├── PaymentService
├── InventoryService
├── AnalyticsService

## How to Run

1. Start Kafka and Zookeeper
2. Start Order Service
3. Start Payment Service
4. Start Inventory Service
5. Start Analytics Service

## Future Enhancements

* Docker Compose deployment
* Kubernetes deployment
* Monitoring with Prometheus and Grafana
* CI/CD pipeline with GitHub Actions

## Author

Ansh Singh
