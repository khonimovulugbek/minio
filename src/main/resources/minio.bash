#!/bin/bash

# Define MinIO download URL and installation directory
MINIO_URL="https://dl.min.io/server/minio/release/linux-amd64/minio"
INSTALL_DIR="/usr/local/bin"

# User credentials and data directory
MINIO_USER="minio"
MINIO_PASSWORD="minio"
DATA_DIR="/mnt/data"

# Console port
CONSOLE_PORT="9001"

# Download MinIO
echo "Downloading MinIO..."
wget $MINIO_URL -O $INSTALL_DIR/minio
if [ $? -ne 0 ]; then
    echo "Failed to download MinIO."
    exit 1
fi

# Make MinIO executable
echo "Making MinIO executable..."
chmod +x $INSTALL_DIR/minio

# Starting MinIO server
echo "Starting MinIO server..."
MINIO_ROOT_USER=$MINIO_USER MINIO_ROOT_PASSWORD=$MINIO_PASSWORD $INSTALL_DIR/minio server $DATA_DIR --console-address ":$CONSOLE_PORT" &

echo "MinIO server is running..."
