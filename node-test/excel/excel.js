var XLSX = require('xlsx');
var datas = require('./data/data.json');

(async()=>{

  json2Excel(datas.data,'./out/example.xls')

})();

// json to Excel
function json2Excel(jsonData, filePath){
  let sheetData = XLSX.utils.json_to_sheet(datas.data);
  let workbook = { //定义操作文档
    SheetNames:['sheetName'], //定义表明
    Sheets:{
      'sheetName':Object.assign({},sheetData,{}) //表对象[注意表明]
    },
  }
  XLSX.writeFile(workbook,filePath); //将数据写入文件
}
