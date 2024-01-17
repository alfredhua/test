import scrapy
from ..items import StockstartItem

class StockSpider(scrapy.Spider):
    name = 'stock'
    allowed_domains = ['quote.stockstar.com']
    start_urls = ['http://quote.stockstar.com/stock/ranklist_a_3_1_1.html']

    def parse(self, response):
        page = int (response.url.split("_")[-1].split(".")[0])
        if page > 10:
            return
        item_nodes = response.css('#datalist tr')
        for item_node in item_nodes:
            stock=StockstartItem()
            stock['code']= item_node.css('td:nth-child(1) a::text').get()
            stock['abbr']= item_node.css('td:nth-child(2) a::text').get()
            stock['last_trade']= item_node.css('td:nth-child(3)::text').get()
            stock['chg_ratio']= item_node.css('td:nth-child(4)::text').get()
            yield stock
            
        if item_node:
            next_page =page+1
            next_url = response.url.replace ("{0}.html".format (page) , "{0}.html".format(next_page))
            yield scrapy.Request(url=next_url,callback=self.parse)

