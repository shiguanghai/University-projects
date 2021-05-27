// components/NewsDetail.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    postid: {
      type: String
    },
    title: {
      type: String
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    detailHtml: ''
  },

  /**
   * 组件的方法列表
   */
  methods: {
    getNewsDetail: function(){
      if (this.data.postid) {
        let postid = this.data.postid
        let url = 'http://c.3g.163.com/nc/article/'+ postid +'/full.html'
        wx.request({
          url: url,
          success: (response) => {
            // console.log(response.data[postid])
            let json = JSON.stringify(response) // 将返回的数据转化为json格式
            // 将返回后的json数据保存到state中
            let rawData = JSON.parse(json).data[postid]
            // console.log(rawData)
            let imgArr = rawData.img // 抽取数据中的图片数组
            let rawHtml = rawData.body // 抽取数据中的htmlbody内容
            imgArr.forEach((imgItem) => { //遍历图片数组将图片插入到body中
              let imgHtml = '<img src="' + imgItem.src + '" width="100%">';
              rawHtml = rawHtml.replace(imgItem.ref, imgHtml);
            })
            this.setData({
              detailHtml: rawHtml, //将拼接好的网页body保存到state中
            })
            // console.log(this.data.detailHtml)
          },
          fail: (err) => {
            console.log(err)
          }
        })
      }
    }
  },

  /**
   * [在组件实例进入页面节点树时执行]
   * 这里写生命周期函数
   * 当调用该组件的页面加载完显示时
   * 组件就会自动触发该函数
   * 来达到组件内初始化数据作用
   */
  ready() {
    // 请求数据（业务逻辑）
    this.getNewsDetail()
  }
})
