
import subprocess
import sys
import os

test_mapping = {
    "Login.java": "LoginTest",
    "Payment.java": "PaymentTest",
    "Registration.java": "RegistrationTest"
}

# Detect changed files
base_ref = os.getenv("GITHUB_BASE_REF")

if base_ref:
    subprocess.run(
        ["git", "fetch", "origin", base_ref],
        check=True
    )
    command = [
        "git", "diff", "--name-only",
        f"origin/{base_ref}...HEAD"
    ]
else:
    command = ["git", "diff", "--name-only", "HEAD"]

result = subprocess.run(
    command,
    capture_output=True,
    text=True
)

if result.returncode != 0:
    print(result.stderr)
    sys.exit(1)

changed_files = result.stdout.splitlines()

print("\nChanged files:", changed_files)

selected_tests = []

for file in changed_files:
    filename = file.split("/")[-1].split("\\")[-1]

    if filename in test_mapping:
        selected_tests.append(test_mapping[filename])

selected_tests = list(dict.fromkeys(selected_tests))

# Run selected tests or all tests
if selected_tests:
    print("\nRunning selected tests:", selected_tests)
    command = [
        "mvn.cmd" if os.name == "nt" else "mvn",
        "-Dtest=" + ",".join(selected_tests),
        "test"
    ]
else:
    print("\nNo mapped Java changes detected.")
    print("Running the complete test suite.")

    command = [
        "mvn.cmd" if os.name == "nt" else "mvn",
        "test"
    ]

sys.exit(subprocess.run(command).returncode)
