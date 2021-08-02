from email.mime.text import MIMEText
from email.mime.multipart import MIMEMultipart
import smtplib
import re #정규 표현식을 위한 패키지

SMTP_SERVER = 'smtp.gmail.com'
SMTP_PORT = 465
SMTP_USER = 'djwhy5510@gmail.com'
SMTP_PASSWORD = 'diddid35165510'

def send_mail(name, addr, subject, contents, attachment=None):
    if not re.match('(^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$)', addr):#정규표현식을 활용한 이메일 검증
        print('Wrong mail')
        return 

    msg = MIMEMultipart('alternative') #it means 'i would contain text in mail '
    if attachment:
        msg = MIMEMultipart('mixed') # it means ' i would contain attachment too!'

    msg['From']= SMTP_USER
    msg['TO'] = addr
    msg['Subject'] = name +'님, ' + subject
    #making mail
    text = MIMEText(contents, _charset='utf-8') #make our text to MIMEText instance.
    msg.attach(text)
    if attachment:
        from email.mime.base import MIMEBase
        from email import encoders
        file_data = MIMEBase('application', 'octect-stream') # attachment definition (normal file)
        file_data.set_payload(open(attachment, 'rb').read()) # load attachment
    #send mail
    smtp = smtplib.SMTP_SSL(SMTP_SERVER, SMTP_PORT)
    smtp.login(SMTP_USER, SMTP_PASSWORD)
    smtp.sendmail(SMTP_USER, addr, msg.as_string())
    smtp.close()

#test
contents = '''안녕하세요.
자동화로 보내는 메일입니다.'''
send_mail('양동주', 'djwhy5510@gmai', '자동화 메일1', contents)