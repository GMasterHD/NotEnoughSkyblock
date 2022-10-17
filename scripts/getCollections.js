import dotenv from 'dotenv'
dotenv.config()

import Request from 'request'
import Inquirer from 'inquirer'
import FS from 'fs'
import { stdin } from 'process'

const ENV = process.env

const titleCase = (s) =>
  s.replace(/^_*(.)|_+(.)/g, (s, c, d) => c ? c.toUpperCase() : ' ' + d.toUpperCase())

const { NES_UUID, NES_KEY, NES_PROFILE } = ENV
console.log(ENV)

const table = {}

console.table({ NES_UUID, NES_KEY })

Request.get(`https://api.hypixel.net/skyblock/profiles?key=${NES_KEY}&uuid=${NES_UUID}`, { method: 'GET' }, (e, r) => {
	if(e) { console.error(e) }

	console.log(r.body)

	const json = JSON.parse(r.body)['profiles'][2]['members'][NES_UUID]['collection']
	console.log(`Found ${Object.keys(json).length} objects!`)

	Object.keys(json).forEach(async k => {
		k = k.toLowerCase()
		let k2 = k
		if(k2.includes('_item')) { k2 = k2.substring(0, k.indexOf('_item')) }
		let name = ''
		if(k.includes(':')) {
			name = ''
		} else if(k == 'log') {
			name = 'Oak Log'
 		} else if(k == 'log_2') {
			name = 'Dark Oak Log'
 		} else {
			name = titleCase(k2.toLowerCase())
		}

		table[k] = name
	})
	FS.writeFileSync('./translation.json', JSON.stringify(table, null, 4), { encoding: 'utf-8' })
})
