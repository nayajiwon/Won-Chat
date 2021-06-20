/*global kakao*/
const area = [
    {
      name:"서울",
      path: [
        new kakao.maps.LatLng(37.70189389950929, 127.01802407127113),
        new kakao.maps.LatLng(37.64700269881479, 126.90816079205291),
        new kakao.maps.LatLng(37.6491773799439, 126.90198098259688),
        new kakao.maps.LatLng(37.59261497959564, 126.88687478170439),
        new kakao.maps.LatLng(37.60675961392841, 126.80516396778583),
        new kakao.maps.LatLng(37.60839151407558, 126.8037906767956),
        new kakao.maps.LatLng(37.557241630538236, 126.76465188357412),
        new kakao.maps.LatLng(37.53818748356839, 126.79211770337866),
        new kakao.maps.LatLng(37.47336695993037, 126.81546365021254),
        new kakao.maps.LatLng(37.473911904683746, 126.81615029570767),
        new kakao.maps.LatLng(37.49298246773486, 126.86764870784121),
        new kakao.maps.LatLng(37.43466572798051, 126.90129433710177),
        new kakao.maps.LatLng(37.46519231184894, 127.03244362666851),
        new kakao.maps.LatLng(37.427032135680946, 127.04342995459035),
        new kakao.maps.LatLng(37.49570643650538, 127.16084633425481),
        new kakao.maps.LatLng(37.54853176770985, 127.18281899009845),
        new kakao.maps.LatLng(37.687223991019806, 127.09286843023854)
      ],
      center: new kakao.maps.LatLng(37.55376543311321, 126.98747458313177),
      level : 8
    },
    {
      name:"경기도",
      path: [
        new kakao.maps.LatLng(37.69982486508043, 127.02098932762576),
        new kakao.maps.LatLng(37.585500416643804, 126.75609532604429),
        new kakao.maps.LatLng(37.63937765447116, 126.65467194706042),
        new kakao.maps.LatLng(37.59211902182923, 126.57472646009663),
        new kakao.maps.LatLng(37.767769108785046, 126.52222494626969),
        new kakao.maps.LatLng(38.29970776856676, 127.07019827612085),
        new kakao.maps.LatLng(37.95481460031062, 127.60706248929324),
        new kakao.maps.LatLng(37.72634069999709, 127.55337606797602),
        new kakao.maps.LatLng(37.64372801102709, 127.54741091005185),
        new kakao.maps.LatLng(37.54920088605192, 127.86058170106908),
        new kakao.maps.LatLng(36.9151629200776, 127.29090911931395),
        new kakao.maps.LatLng(36.9151629200776, 126.903173854245),
        new kakao.maps.LatLng(37.22691146697932, 126.53631664191055),
        new kakao.maps.LatLng(37.55393009391567, 126.7510623271795),
        new kakao.maps.LatLng(37.48296047377793, 126.87334806462432),
        new kakao.maps.LatLng(37.46583465185977, 127.0013236337012),
        new kakao.maps.LatLng(37.429750279899416, 127.04499281511984),
        new kakao.maps.LatLng(37.50048755304439, 127.15550258034253),
        new kakao.maps.LatLng(37.54784407357252, 127.18134760608011),
        new kakao.maps.LatLng(37.57963381378512, 127.17689156715981)
      ],
      center: new kakao.maps.LatLng(37.596995195111944, 127.19195300739753),
      level:10
    },
    {
      name: "강원도",
      path: [
        new kakao.maps.LatLng(38.59068167787227, 128.36258146032122),
        new kakao.maps.LatLng(38.30428937119569, 127.11378026275032),
        new kakao.maps.LatLng(37.94029487072038, 127.60337083097215),
        new kakao.maps.LatLng(37.64650217610361, 127.55368042646627),
        new kakao.maps.LatLng(37.54854344317131, 127.8480517671416),
        new kakao.maps.LatLng(37.17887839000607, 127.77151521856601),
        new kakao.maps.LatLng(37.04272207497729, 129.21393478787508),
        new kakao.maps.LatLng(37.16889561007584, 129.35533487604926),
        new kakao.maps.LatLng(38.40222967493191, 128.46940913564026),
      ],
      center: new kakao.maps.LatLng(37.78310123055565, 128.18150850625435),
      level: 10
    },
    {
      name: "충청북도",
      path: [
        new kakao.maps.LatLng(37.204801614743715, 127.74434004377326),
        new kakao.maps.LatLng(36.92866168820029, 127.29115403836623),
        new kakao.maps.LatLng(36.24278717905133, 127.48890793163476),
        new kakao.maps.LatLng(36.13416848060653, 127.59877120567282),
        new kakao.maps.LatLng(36.02984173630971, 127.86244306336421),
        new kakao.maps.LatLng(36.240571977011825, 128.03822430182512),
        new kakao.maps.LatLng(36.72640142709099, 127.9530802644456),
        new kakao.maps.LatLng(36.80345600318842, 128.33757301785315),
        new kakao.maps.LatLng(37.058577604481926, 128.6484052264402),
        new kakao.maps.LatLng(37.217870837095, 128.3403483054298)
      ],
      center: new kakao.maps.LatLng(36.620662231485845, 127.66468918271353),
      level: 10
    },
    {
      name: "충청남도",
      path: [
        new kakao.maps.LatLng(37.05262111003981, 126.51093183625333),
        new kakao.maps.LatLng(36.885089523225915, 126.19640199073119),
        new kakao.maps.LatLng(36.68311089885482, 126.16239876418824),
        new kakao.maps.LatLng(36.334662724313105, 126.35442520452251),
        new kakao.maps.LatLng(36.009148965482325, 126.70308010068591),
        new kakao.maps.LatLng(36.12177445579507, 127.34001060620213),
        new kakao.maps.LatLng(35.976762051712434, 127.48811660873199),
        new kakao.maps.LatLng(36.21274944025642, 127.59405565347191),
        new kakao.maps.LatLng(36.79500019880233, 127.40222008596987),
        new kakao.maps.LatLng(36.97195511068382, 127.10915799172278)
      ],
      center: new kakao.maps.LatLng(36.57133704598582, 126.84318124965725),
      level: 10
    },
    {
      name: "전라북도",
      path: [
        new kakao.maps.LatLng(35.96217164809523, 126.53722625331197),
        new kakao.maps.LatLng(35.42985450900436, 126.42659882050324),
        new kakao.maps.LatLng(35.30828453765931, 126.5304259425525),
        new kakao.maps.LatLng(35.30828453765931, 127.56337269524762),
        new kakao.maps.LatLng(35.43419290631401, 127.6698620511956),
        new kakao.maps.LatLng(35.93585771486769, 127.90946310207848),
        new kakao.maps.LatLng(36.02949850012795, 127.84768688468195),
        new kakao.maps.LatLng(36.120004484713895, 127.33615190671273),
        new kakao.maps.LatLng(36.08916187382496, 127.0714770922411),
        new kakao.maps.LatLng(36.15494480258801, 126.94168463514441)
      ],
      center: new kakao.maps.LatLng(35.75359749136055, 127.14390729367938),
      level:10
    },
    {
      name: "전라남도",
      path: [
        new kakao.maps.LatLng(35.32495403950247, 126.59579885340781),
        new kakao.maps.LatLng(34.555137029373, 126.28401446112127),
        new kakao.maps.LatLng(34.46523224312979, 126.92969646085358),
        new kakao.maps.LatLng(34.74068284946708, 127.32242383921192),
        new kakao.maps.LatLng(34.98803250747294, 127.75940218977968),
        new kakao.maps.LatLng(35.3610424665125, 127.49942772804948),
        new kakao.maps.LatLng(35.32321839613474, 127.03573406443478),
        new kakao.maps.LatLng(35.45663603952111, 127.03846167422074),
        new kakao.maps.LatLng(35.31431604180598, 126.54203669317437)
      ],
      center: new kakao.maps.LatLng(34.91561694420115, 126.94615339074608),
      level:10
    },
    {
      name: "경상남도",
      path: [
        new kakao.maps.LatLng(35.62576823048089, 129.01717971640974),
        new kakao.maps.LatLng(35.67486877099313, 128.5337813106422),
        new kakao.maps.LatLng(35.663712207523986, 128.16848592446564),
        new kakao.maps.LatLng(35.681561960595026, 128.204191488528),   
        new kakao.maps.LatLng(35.90657144848201, 127.89382773937045),
        new kakao.maps.LatLng(35.565467241316256, 127.5889571539148),
        new kakao.maps.LatLng(34.73681659117759, 127.85812217530805),
        new kakao.maps.LatLng(34.88339652316375, 128.4733565099213),
        new kakao.maps.LatLng(35.41787371107798, 129.2149336096783),
        
      ],
      center: new kakao.maps.LatLng(35.46486469339571, 128.32229453214657),
      level:11
    },
    {
      name: "경상북도",
      path:[
        new kakao.maps.LatLng(37.4202989260392, 129.183443705355),
        new kakao.maps.LatLng(37.04546026031903, 128.23614408701374),
        new kakao.maps.LatLng(36.44873807697983, 127.86806682229891),
        new kakao.maps.LatLng(36.23587430375662, 127.89402523623116),
        new kakao.maps.LatLng(35.66767099781702, 128.1936230070921),
        new kakao.maps.LatLng(36.00077386081608, 128.67297944046962),
        new kakao.maps.LatLng(35.658289796870065, 128.53314266295297),
        new kakao.maps.LatLng(35.658289796870065, 129.46247458019903),
        new kakao.maps.LatLng(36.904702304465175, 129.43662048969054)
      ],
      center: new kakao.maps.LatLng(36.29252676927618, 128.90471034701088),
      level:11
    }
  ]

  module.exports= area;