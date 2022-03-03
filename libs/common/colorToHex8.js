const TinyColor = require('@ctrl/tinycolor')

module.exports = {
  type: 'value',
  matcher: function (token) {
    return token.type === 'color'
  },
  transformer: function ({ value }) {
    // removed alpha channel
   // return `${new TinyColor.TinyColor(value).toHexString()}`
    return `${new TinyColor.TinyColor(value).toHexString()}`
  }
}
