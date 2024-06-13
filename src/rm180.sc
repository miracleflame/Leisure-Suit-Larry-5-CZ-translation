;;; Sierra Script 1.0 - (do not remove this comment)
(script# 180)
(include sci.sh)
(use Main)
(use LLRoom)
(use Polygon)
(use CueObj)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm180 0
)

(local
	local0
)
(instance rm180 of LLRoom
	(properties
		lookStr {Spisovna PPC je plná kartoték, které jsou naplnìny spisy.}
		picture 180
		south 160
	)
	
	(method (init)
		(self setRegions: 40)
		(gLarry init: normalize:)
		(switch gGNumber
			(south (gLarry x: 200))
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(super init:)
		(imprinter init: approachVerbs: 3)
		(light init:)
		(bookcase init:)
		(nudePainting init:)
		(desk init:)
		(lamp init:)
		(magnifier init:)
		(drawer init: approachVerbs: 3)
		(loserDrawer1 init: approachVerbs: 3)
		(loserDrawer2 init: approachVerbs: 3)
		(loserDrawer3 init: approachVerbs: 3)
		(books init:)
		(fan init:)
		(chair init:)
		(fTwins init:)
		(fRolls init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						319
						0
						319
						189
						244
						189
						284
						152
						259
						154
						218
						127
						220
						118
						163
						121
						96
						119
						80
						136
						82
						141
						54
						168
						158
						168
						165
						189
						0
						189
					yourself:
				)
		)
	)
)

(instance imprinter of Prop
	(properties
		x 128
		y 1162
		z 1000
		description {tiskárna kreditních karet}
		approachX 137
		approachY 165
		view 180
		priority 15
		signal $4010
	)
	
	(method (init)
		(if (gLarry has: 7)
			(self setCel: 1)
		else
			(self setCel: 0)
		)
		(super init:)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(if (gLarry has: 7)
					(proc0_14 180 0)
				else
					(proc0_14 180 1)
				)
			)
			(3
				(if (gLarry has: 7)
					(proc0_14 180 2)
				else
					(self setScript: sGetCard)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance drawer of Actor
	(properties
		x 266
		y 125
		description {zásuvka}
		sightAngle 40
		approachX 240
		approachY 140
		view 180
		loop 2
		signal $0800
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(cond 
					((gLarry has: 5) (proc0_14 180 3))
					(local0 (proc0_14 180 4))
					(else (proc0_14 180 5))
				)
			)
			(3
				(cond 
					((gLarry has: 5) (proc0_14 180 6))
					(local0 (self setScript: sDrawer 0 1))
					(else (self setScript: sDrawer 0 0))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance sGetCard of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					view: 181
					setLoop: 2
					setCel: 0
					posn: 141 157
					setPri: 15
					cycleSpeed: 12
					setCycle: End self
				)
			)
			(1
				(proc0_10 5 88)
				(gLarry setCycle: Beg self)
			)
			(2
				(imprinter setCel: 1 approachVerbs: 0)
				(gLarry setLoop: 2 posn: 137 165 get: 7 normalize:)
				(= cycles 2)
			)
			(3
				(proc0_14 180 7)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sDrawer of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(if (== register 1)
					(self changeState: 3)
				else
					(gLarry
						view: 181
						setLoop: 0
						setCel: 0
						cycleSpeed: 12
						setCycle: CT 2 1 self
					)
				)
			)
			(1
				(gLarry setCycle: End)
				(drawer setMotion: MoveTo 255 (drawer y?) self)
				(gLongSong2 number: 181 setLoop: 1 play:)
			)
			(2
				(= local0 1)
				(self changeState: 6)
			)
			(3
				(gLarry view: 181 setLoop: 1 setCel: 0 setCycle: End self)
			)
			(4
				(proc0_10 8 89)
				(gLarry get: 5 15 19)
				(drawer setLoop: 1)
				(= cycles 1)
			)
			(5
				(gLarry setLoop: 0 setCel: 255 setCycle: Beg self)
				(gLongSong2 number: 182 setLoop: 1 play:)
				(drawer setMotion: MoveTo 263 (drawer y?))
				(= local0 0)
				(drawer approachVerbs: 0)
			)
			(6
				(if (== register 1) (proc0_14 180 8))
				(gLarry normalize:)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance light of Feature
	(properties
		x 220
		y 40
		nsTop 18
		nsLeft 210
		nsBottom 62
		nsRight 231
		description {svìtlo}
		sightAngle 40
		lookStr {Dívat se do lampy je pro tebe osvícený zážitek.}
	)
)

(instance bookcase of Feature
	(properties
		x 157
		y 47
		nsTop 34
		nsLeft 113
		nsBottom 61
		nsRight 201
		description {knihovna}
		sightAngle 40
		lookStr {V této knihonì jsou jen samé knihy.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance nudePainting of Feature
	(properties
		x 60
		y 57
		nsTop 38
		nsLeft 43
		nsBottom 76
		nsRight 78
		description {obrázek aktu}
		sightAngle 40
		lookStr {O umìní toho moc nevíš, ale nìco se ti na tom obraze zamlouvá!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 10))
			(5 (proc0_14 180 11))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance desk of Feature
	(properties
		x 89
		y 165
		nsTop 154
		nsLeft 33
		nsBottom 176
		nsRight 145
		description {tvùj psací stùl}
		sightAngle 40
		lookStr {Proè tady nejsou žádní pracovníci?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 12))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance lamp of Feature
	(properties
		x 46
		y 158
		nsTop 145
		nsLeft 35
		nsBottom 171
		nsRight 58
		description {lampa}
		sightAngle 40
		lookStr {Obdivuješ každého, kdo používá žárovkové osvìtlení.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 13))
			(5 (proc0_18 gLarry 180 14))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance magnifier of Feature
	(properties
		x 95
		y 159
		nsTop 144
		nsLeft 73
		nsBottom 174
		nsRight 117
		description {lupa}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 180 15)
				(proc0_14 180 16)
				(proc0_14 180 17 67 -1 185)
			)
			(3 (proc0_14 180 18))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance loserDrawer1 of Feature
	(properties
		x 257
		y 124
		nsTop 97
		nsLeft 233
		nsBottom 152
		nsRight 281
		description {zásuvka se složkami}
		sightAngle 40
		approachX 226
		approachY 135
		lookStr {Tahle zásuvka je nadepsaná "Lùzøi". Hledáš složky tøí finalistù. Teï není èas na to, aby sis rozšiøoval svùj diáø, Larry!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance loserDrawer2 of Feature
	(properties
		x 155
		y 93
		nsTop 71
		nsLeft 100
		nsBottom 116
		nsRight 210
		description {zásuvka se složkami}
		sightAngle 40
		lookStr {Tato zásuvka je oznaèena "Lùzøi". Hledáš složky tøí finalistek. Teï není èas na to, aby sis rozšiøoval svùj diáø, Larry!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance loserDrawer3 of Feature
	(properties
		x 63
		y 123
		nsTop 101
		nsLeft 40
		nsBottom 149
		nsRight 87
		description {zásuvka se složkami}
		sightAngle 40
		lookStr {Tato zásuvka je oznaèena "Lùzøi". Hledáš složky tøí finalistek. Teï není èas na to, aby sis rozšiøoval svùj diáø, Larry!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 19))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance books of Feature
	(properties
		x 57
		y 93
		nsTop 87
		nsLeft 46
		nsBottom 99
		nsRight 69
		description {nìjaké knihy}
		sightAngle 40
		lookStr {Proè se chceš dívat na knihy, Larry? Sotva umíš èíst!}
	)
)

(instance fan of Feature
	(properties
		x 263
		y 87
		nsTop 75
		nsLeft 254
		nsBottom 100
		nsRight 273
		description {vìtrák}
		sightAngle 40
		lookStr {Tohle je tvùj nejvìtší fanoušek!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_14 180 20)
				(proc0_14 180 21 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 222
		y 104
		nsTop 96
		nsLeft 212
		nsBottom 113
		nsRight 232
		description {tvoje židle}
		sightAngle 40
		lookStr {Tahle židle je tvé oblíbené místo na spaní na pracovišti.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 180 22))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance fTwins of Feature
	(properties
		x 100
		y 111
		z 66
		nsTop 31
		nsLeft 93
		nsBottom 60
		nsRight 108
		description {plakát dvojèat}
		sightAngle 40
		lookStr {Tento plakát je tvùj oblíbený. Vždycky jsi mìl slabost pro dvojèata.}
	)
	
	(method (doVerb theVerb &tmp [temp0 100])
		(if (== theVerb 2)
			(Format
				@temp0
				180
				23
				(if (proc0_6 0) {zrzavá} else {blondýnka})
			)
			(proc0_14 @temp0)
		else
			(super doVerb: theVerb &rest)
		)
	)
)

(instance fRolls of Feature
	(properties
		x 91
		y 103
		nsTop 93
		nsLeft 82
		nsBottom 114
		nsRight 101
		description {role papíru}
		sightAngle 40
		lookStr {Tady leží nìjaké nedùležité role papíru.}
	)
)
