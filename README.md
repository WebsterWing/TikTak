# TikTak
The premier social network for tic-tac-toe enthusiasts


This is the codebase for a website which allows people to play tic-tac-toe on the internet, 
and also examine the games which others have played.


## Feature roadmap
- literally any code
- playable tic-tac-toe
- examination of previous tic-tac-toe games
- other things IDK

## AWS deploy

```bash
# create keypair for EC2 Instance, save for ssh
aws ec2 create-key-pair --key-name tiktak-ec2-keypair --query "KeyMaterial" --output text > ~/tiktak.pem

cd cloudformation
./update.sh
```
