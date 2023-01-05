((redactables) => {
  const mainNode = $('main')
  const text = [
    '<!DOCTYPE html>',
    '<head>',
    '<!-- generated: ' + new Date().toISOString() + ' -->',
    '<!-- answares: ' + $$('.markdown').length + ' -->',
    '<!-- title: ' + document.title + ' -->',
    '<title>saved: ' + document.title + '</title>',
    '<script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>',
    '<style>',
    '  button, form { display: none !important; }',
    '</style>',
    '</head>',
    '<body>',
    '<main class="' + mainNode.className + '">',
    mainNode.innerHTML,
    '</main>',
    '</body>',
  ]
  .map(line => redactables ? line.replaceAll(redactables, '[REDACTED]') : line)
  const textBlob = new Blob(text, {
    type: 'text/html',
  });
  const downloadAnchor = document.createElement('a');
  downloadAnchor.download =
    [
      new Date().toISOString().split(':').splice(0,2).join('').split('T').join(' '),
     'ChatGPT',
     document.title,
     // new Date().toLocaleString()
     // new Date().toISOString().split('T')[0]
    ]
    .join(' - ')
    .concat('.html');
  downloadAnchor.href = window.URL.createObjectURL(textBlob);
  downloadAnchor.click();
})("{string literal or regexp to redact}")