from my_email import Email
from my_news import News
from my_excel import Excel

m_email = Email()
m_news = News()
m_excel = Excel()

news_list = m_news.find_news('fastcampus')

m_email.from_email = 'djwhy5510@gmail.com'
m_email.to_email = 'djwhy5510@naver.com'
m_email.subject = 'dear.'

for news in news_list:
    m_email.contents = m_email.contents+news+'\n'
m_email.send_mail()

m_excel.excel_file = 'result.xlsx'
m_excel.save_to_excel(news_list)
