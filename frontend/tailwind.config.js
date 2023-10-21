/* eslint-disable @typescript-eslint/no-var-requires */
const plugin = require('tailwindcss/plugin')

/** @type {import('tailwindcss').Config} */
export default {
  content: ['./index.html', './src/**/*.{js,ts,jsx,tsx}'],
  corePlugins: {
    container: false
  },
  theme: {
    extend: {
      colors: {
        orange: '#ee4d2d',
        primary: '#212F48', // Màu chính
        background: '#162134',
        secondary: '#2B3B58', // Màu phụ ',
        textPlaceholder: '#A6ACB6',
        primaryButton: '#0085ff'
      }
    }
  },
  plugins: [
    plugin(function ({ addComponents, theme }) {
      addComponents({
        '.container': {
          maxWidth: theme('columns.7xl'),
          marginLeft: 'auto',
          marginRight: 'auto',
          paddingRight: theme('spacing.4'),
          paddingLeft: theme('spacing.4')
        }
      })
    })
  ]
}
