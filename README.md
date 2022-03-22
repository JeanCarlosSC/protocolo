# Simulador de protocolo
📚 Una simulación de protocolo que permite la interacción de mensajes de control y de datos de acuerdo a unas reglas establecidas para la comunicación. (Asignatura: Redes de Comunicaciones I)

## Notas para el correcto funcionamiento
- El primer ajuste del transmisor es manual (activar ppt y ctr, también colocar el mensaje a transmitir y el No. de frames).
- Cada vez que el Transmisor envíe una trama, se deberá enviar la respuesta del receptor manualmente antes de enviar otra trama.
- El receptor sólo debe responder 1 vez manualmente por cada trama enviada por el transmisor. (para evitar mensajes duplicados en la secuencia de tramas)
- Los valores de respuesta se colocan automáticamente al recibir una trama, no es necesario modificarlo, podría cambiar el mensaje que le envía al sistema.
- El "mensaje a transmitir" y "Frames" se escriben antes de presionar el botón enviar por primera vez, no deben estar vacíos, escribir datos válidos.
- Para que funcione automáticamente sin problemas, no editar tramas (podría provocar alguna excepción).

## Dudas
- Quita el header y el trailer y guarda la información para ser ensamblada cuando termine la transmisión.