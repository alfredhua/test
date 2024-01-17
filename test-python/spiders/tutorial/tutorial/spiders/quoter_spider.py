import scrapy

class QuotesCpider(scrapy.Spider):
    name = "a"

    def start_requests(self):
        urls =[
            'http://quotes.toscrape.com/page/1/',
            'http://quotes.toscrape.com/page/2/',
        ]
        for url in urls:
            yield scrapy.Request(url=url,callback=self.parse)
    
    def parse(self, response, **kwargs):
        page = response.url.split("/")[-2]
        filename=f'a-{page}.html'
        with open(filename,'wb') as f:
            f.write(response.body)
        self.log(f'save file {filename}')