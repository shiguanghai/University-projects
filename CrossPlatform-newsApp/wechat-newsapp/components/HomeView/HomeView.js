// components/HomeView.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    // 这里定义了innerText属性，属性值可以在组件使用时指定
    // innerText: {
    //   type: String,
    //   value: 'default value',
    // }
  },

  /**
   * 组件的初始数据
   */
  data: {
    // 这里是一些组件内部数据
    newsUrl: "http://c.m.163.com/nc/article/headline/T1348647853363/0-40.html",
    newsKey: "T1348647853363",
    
    headerNews: [],
    rowNews: [],
    refreshing: false,
    _navigation: {}

  },

  /**
   * 组件的方法列表
   */
  methods: {
    // 这里是一个自定义方法
    getNewsData: function(){
      wx.request({
        url: this.data.newsUrl,
        success: (response) => {
          // console.log(response)
          let json = JSON.stringify(response.data[this.data.newsKey]) // 将返回的数据转化为json格式
          // 将返回后的json数据保存到state中
          let rawData = JSON.parse(json)
          // console.log(rawData)
          this.setData({
            headerNews: rawData.slice(1, 5),
            rowNews: rawData.slice(5)
          })
          // console.log(this.data.headerNews)
        },
        fail: (err) => {
          console.log(err)
        }
      })
    }
  },

  /**
   * [在组件实例进入页面节点树时执行]
   * 这里写生命周期函数
   * 当调用该组件的页面加载完显示时
   * 组件就会自动触发该函数
   * 来达到组件内初始化数据作用
   */
  attached() {
    // 请求数据（业务逻辑）
    this.getNewsData()
  }

})
