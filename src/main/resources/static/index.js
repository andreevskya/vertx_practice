const ws = new WebSocket('ws://localhost:8080')
const { href } = window.location
const rootUrl = href.substring(0, href.length - 10)

const initSocket = map => {
  const flagsOnMap = {}
  const FlagIcon = L.Icon.extend({
    options: { iconSize: [45, 45], tooltipAnchor: [0, -20] }
  })

  ws.onmessage = mes => {
    const heroInfo = JSON.parse(mes.data)
    const icon = new FlagIcon({
      iconUrl: `${rootUrl}/images/coat-of-arms/${heroInfo.house}.png`
    })
    const marker = new L.Marker([heroInfo.y, heroInfo.x], { icon })
    const activeMarker = flagsOnMap[heroInfo.hero]

    if (activeMarker) activeMarker.remove(map)

    flagsOnMap[heroInfo.hero] = marker
    marker.addTo(map).bindTooltip(heroInfo.hero)
  }
}

const init = () => {
  const map = L.map('map-id', {
    crs: L.CRS.Simple,
    minZoom: 0,
    maxZoom: 0,
    dragging: false,
    zoomControl: false
  })
  const mapBounds = [[0,0], [890, 1288]]

  L.imageOverlay(`${rootUrl}/images/map/map.png`, mapBounds).addTo(map)
  map.fitBounds(mapBounds)

  initSocket(map)
}

init()
