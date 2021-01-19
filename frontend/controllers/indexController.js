/**
 * indexController.
 *
 * @author Marcus Cvjeticanin
 * @version 1.0.0
 */

'use strict'

const fetch = require('node-fetch');
const indexController = {}

/**
 * Displays a start page.
 *
 * @param {object} req - Express request object.
 * @param {object} res - Express response object.
 * @param {Function} next - Express next middleware function.
 */
indexController.index = async (req, res, next) => {
  fetch(`http://localhost:8080/post/list`)
  .then(response => {
      return response.json()
  })
  .then(data => {
      console.log(data)
      res.render('index', { title: 'Welcome to Reddit!', posts: data })
  })
  .catch (error => {
      next(error)
  })
}

module.exports = indexController
