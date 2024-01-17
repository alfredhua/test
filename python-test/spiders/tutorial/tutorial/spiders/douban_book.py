import scrapy
from ..items import DouBanBook

class douban_book(scrapy.Spider):

    name = 'douban'
    hds={'User-Agent':'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US; rv:1.9.1.6) Gecko/20091201 Firefox/3.5.6'}
    
    def start_requests(self):
        title='理财'
        url ='https://www.douban.com/tag/'+title+'/book?start=0'
        yield scrapy.Request(url=url,headers=self.hds,callback=self.parse)
        # url ='https://book.douban.com/subject/3576486/?from=tag_all'
        # yield scrapy.Request(url=url,headers=self.hds,callback=self.parse_detail)

    def parse(self, response, **kwargs):
        dls=response.css('div.article dl')
        if dls == None:
            return
        for dl in dls:
            url= dl.css('dd a::attr(href)').get()
            yield scrapy.Request(url=url,callback=self.parse_detail,headers=self.hds,meta={"book": book})
        start=response.url.split('?')[1]
        current_start=int(start.split('=')[1])
        next_start=(current_start+15)
        next_url=response.url.replace(start,"start={0}".format(next_start))
        yield scrapy.Request(url=next_url,headers=self.hds,callback=self.parse)

    
    def parse_detail(self,response,**kwargs):
        book=DouBanBook()
        book['book_name'] = response.css('').get() 
        book['desc'] = response.css('').get() 
        person_num=response.css('#interest_sectl .rating_sum a span::text').get()
        score=response.css('#interest_sectl strong::text').get()
        author=response.css('#info span:nth-child(1) a::text').get()
        book['person_num']=person_num
        book['score']=score
        book['author']=author
        yield book
#info > span:nth-child(1) > a
