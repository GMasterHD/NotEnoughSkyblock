let collections = {}

import FS from 'fs'

collections = JSON.parse(FS.readFileSync('./translation.json'))

let out = 'static {\n\t'
Object.keys(collections).forEach(k => {
	out += `TRANSLATION_MAP.insert("${k}", "${collections[k]}")\n\t`
})
out += `\n}`

FS.writeFileSync('./test.java', out, { encoding: 'utf-8' })
