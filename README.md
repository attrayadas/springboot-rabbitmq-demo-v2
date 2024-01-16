# RabbitMQ Installation Guide for Windows

## Prerequisites
1. **Erlang Installation:**
   - Download Erlang from [http://erlang.org/download/otp_win64_22.3.exe](http://erlang.org/download/otp_win64_22.3.exe).
   - Install Erlang by following the installation wizard.

2. **RabbitMQ Installation:**
   - Download RabbitMQ from [https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe](https://github.com/rabbitmq/rabbitmq-server/releases/download/v3.8.8/rabbitmq-server-3.8.8.exe).
   - Install RabbitMQ by following the installation wizard.

## RabbitMQ Setup Steps
3. **Enable RabbitMQ Management Plugin:**
   - Navigate to the RabbitMQ Server install directory, typically located at `C:\Program Files\RabbitMQ Server\rabbitmq_server-{version}\sbin`.

4. **Run Command to Enable Management Plugin:**
   - Open a command prompt in the RabbitMQ sbin directory.
   - Run the command: `rabbitmq-plugins enable rabbitmq_management`.

5. **Access RabbitMQ Dashboard:**
   - Open a web browser and enter [http://localhost:15672/](http://localhost:15672/) or [http://127.0.0.1:15672/](http://127.0.0.1:15672/).
   - Log in with the default credentials: Username - `guest`, Password - `guest`.

6. **Explore RabbitMQ Dashboard:**
   - After successful login, you will be redirected to the RabbitMQ Home page.

