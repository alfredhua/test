import scrapy
from scrapy.selector import Selector

class QuotesCpider(scrapy.Spider):
    name = "cxy"

    def start_requests(self):
        urls =[
            'https://cxy521.com/',
        ]
        for url in urls:
            yield scrapy.Request(url=url,callback=self.parse)
    
    def parse(self, response, **kwargs):
        lis=response.css('div.main-content ul li').getall()
        for li in lis:
            yield{
                "image":Selector(text=li).css('img::attr(src)').get(),
                "title":Selector(text=li).css('a::text').get(),
                "description":Selector(text=li).css('p::text').get()
            }
        return None