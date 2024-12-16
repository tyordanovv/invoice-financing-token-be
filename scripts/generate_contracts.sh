#!/bin/bash

# Set project variables
PROJECT_ROOT=$(pwd)
CONTRACTS_DIR="$PROJECT_ROOT/contracts"
OUTPUT_DIR="$PROJECT_ROOT/src/main/java/com/yourproject/contracts"
WEB3J_CLI_JAR="/path/to/web3j-cli-full.jar"  # Update this path

# Create output directory if it doesn't exist
mkdir -p "$OUTPUT_DIR"

# Loop through all .sol files in the contracts directory
for sol_file in "$CONTRACTS_DIR"/*.sol; do
    # Check if any .sol files exist
    [ -e "$sol_file" ] || continue

    # Extract contract name (filename without extension)
    contract_name=$(basename "$sol_file" .sol)

    echo "Generating Java wrapper for $contract_name"

    # Web3j CLI command to generate Java wrapper
    java -jar "$WEB3J_CLI_JAR" solidity generate \
        -b "$CONTRACTS_DIR/$contract_name.bin" \
        -a "$CONTRACTS_DIR/$contract_name.abi" \
        -o "$OUTPUT_DIR" \
        -p "com.yourproject.contracts"
done

echo "Contract generation complete!"