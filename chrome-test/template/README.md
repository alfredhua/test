Pages:
  Background，存放后台文件
  content，存放往页面里注入的脚本文件，这是直接注入到页面里的脚本
  devtools，用于开发devtool工具的，基本上用不到
  NewTab，用于自定义开发tab页的
  Options，用于开发扩展选项的
  Panel，用于开发面板的，基本上用不到
  Popup，用于开发弹窗页的

```json
{
  "name": "Chrome插件V3",
  "version": "1.0",
  "description": "React开发chrome插件V3 Demo。",
  // Chrome Extension 版本号，3表示MV3
  "manifest_version": 3,
  // background script配置（根目录为最终build生成的插件包目录）
  "background": {
    "service_worker": "static/js/background.js"
  },
  // content script配置
  "content_scripts": [
    {
      // 应用于哪些页面地址（可以使用正则，<all_urls>表示匹配所有地址）
      "matches": ["<all_urls>"],
      // 注入到目标页面的css，注意不要污染目标页面的样式
      "css": ["static/css/content.css"],
      // 注入到目标页面js，这个js是在沙盒里运行，与目标页面是隔离的，没有污染问题。
      "js": ["static/js/content.js"],
      // 代码注入的时机，可选document_start、document_end、document_idle（默认）
      "run_at": "document_end"
    }
  ],
  // 申请chrome extension API权限
  "permissions": ["storage","declarativeContent"],
  // 插件涉及的外部请求地址，暂未发现影响跨域请求，猜测是用于上架商店时方便审核人员查阅
  "host_permissions":[],
  // 如果向目标页面插入图片或者js，需要在这里授权插件本地资源（以下仅为示例）。
  "web_accessible_resources": [
    {
      "resources": [ "/images/app.png" ],
      "matches": ["<all_urls>"]
    },
    {
      "resources": [ "insert.js" ],
      "matches": ["<all_urls>"]
    }
  ],
  // popup页面配置
  "action": {
    // popup页面的路径（根目录为最终build生成的插件包目录）
    "default_popup": "index.html",
    // 浏览器插件按钮的图标
    "default_icon": {
      "16": "/images/app.png",
      "32": "/images/app.png",
      "48": "/images/app.png",
      "128": "/images/app.png"
    },
    // 浏览器插件按钮hover显示的文字
    "default_title": "React CRX MV3"
  },
  // 插件图标，图省事的话，所有尺寸都用一个图也行
  "icons": {
    "16": "/images/app.png",
    "32": "/images/app.png",
    "48": "/images/app.png",
    "128": "/images/app.png"
  }
}
```
