;;; Sierra Script 1.0 - (do not remove this comment)
(script# 190)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use Cycle)
(use InvI)
(use PicView)
(use Obj)

(public
	rm190 0
)

(instance rm190 of LLRoom
	(properties
		lookStr {Jste pøed generálním øeditelstvím PPC, které se ukrývá ve smogu pod hollywoodskými kopci. Božíèku, jak se ti líbí být v showbyznysu!}
		picture 190
		north 160
	)
	
	(method (init)
		(self setRegions: 40)
		(gLarry init: normalize: 552 setStep: 2 1)
		(proc0_3)
		(super init:)
		(if
			(and
				(gLarry has: 5)
				(gLarry has: 15)
				(gLarry has: 19)
				(gLarry has: 7)
			)
			(limo init: approachVerbs: 3)
		)
		(gLongSong2 number: 193 setLoop: -1 play:)
		(fountain setCycle: Fwd init: approachVerbs: 3 10)
		(waves setCycle: Fwd init: approachVerbs: 3)
		(statue init:)
		(logo init:)
		(tree init:)
		(buildings1 init:)
		(buildings2 init:)
		(windows1 init:)
		(windows2 init:)
		(doorATP init:)
		(debugFeature init:)
		(global2
			addObstacle:
				(if (gCast contains: limo)
					((Polygon new:)
						type: 2
						init:
							0
							0
							179
							0
							179
							132
							76
							132
							64
							125
							5
							125
							5
							133
							61
							133
							76
							136
							65
							143
							24
							145
							4
							150
							4
							158
							147
							158
							202
							175
							218
							187
							309
							187
							309
							167
							276
							163
							273
							156
							315
							146
							315
							122
							253
							136
							243
							143
							225
							143
							216
							134
							192
							134
							192
							0
							319
							0
							319
							189
							0
							189
						yourself:
					)
				else
					((Polygon new:)
						type: 2
						init:
							0
							0
							179
							0
							179
							133
							71
							133
							64
							125
							5
							125
							5
							140
							23
							140
							23
							146
							5
							150
							5
							158
							151
							158
							202
							175
							218
							187
							313
							187
							309
							167
							276
							163
							273
							156
							315
							146
							315
							122
							253
							137
							243
							143
							225
							143
							216
							134
							192
							134
							192
							0
							319
							0
							319
							189
							0
							189
						yourself:
					)
				)
		)
		(proc0_17 2 1 self)
	)
	
	(method (cue)
		(door init: approachVerbs: 3)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber 200)
			(gLongSong fade:)
		else
			(gLongSong fade: 127 25 10 0)
		)
		(gLongSong2 fade:)
		(super newRoom: newRoomNumber)
	)
)

(instance sEnterLimo of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setHeading: 180 self)
			)
			(1
				(gLarry
					moveSpeed: 10
					setMotion: MoveTo (gLarry x?) 137 self
				)
				(= ticks 10)
			)
			(2
				(gLarry hide:)
				(gLongSong2 number: 191 setLoop: 1 play:)
				(= ticks 50)
			)
			(3)
			(4
				(gLongSong2 number: 192 setLoop: 1 play:)
				(= ticks 100)
			)
			(5 (= ticks 20))
			(6 (global2 newRoom: 200))
		)
	)
)

(instance limo of View
	(properties
		x 10
		y 1138
		z 1000
		description {tvá limuzína}
		approachX 29
		approachY 136
		lookStr {Koneènì! Koneènì se mùžeš svézt opravdovou limuzínou.}
		view 190
		priority 9
		signal $0010
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(3
				(global2 setScript: sEnterLimo)
			)
			(else 
				(super doVerb: theVerb &rest)
			)
		)
	)
)

(instance door of Door
	(properties
		x 175
		y 132
		heading 180
		description {vstupní dveøe PornProdCorp}
		approachX 185
		approachY 134
		lookStr {Tyto dveøe vedou zpìt do vestibulu PPC.}
		view 192
		loop 2
		entranceTo 160
		moveToX 185
		moveToY 128
		enterType 1
		exitType 0
	)
)

(instance doorATP of PicView
	(properties
		x 185
		y 130
		view 190
		loop 1
	)
)

(instance fountain of Prop
	(properties
		x 92
		y 160
		description {fontána}
		sightAngle 40
		lookStr {Když míjíš zurèící vodu, chceš vypustit zurèící vodu.}
		view 192
		priority 15
		signal $0010
		detailLevel 2
	)
	
	(method (doVerb theVerb param2 &tmp [temp0 30])
		(switch theVerb
			(3 (proc0_14 190 0))
			(4
				(Format @temp0 190 1 ((Inv at: param2) description?))
				(proc0_14 @temp0)
			)
			(10 (proc0_14 190 0))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance waves of Prop
	(properties
		x 89
		y 189
		sightAngle 40
		view 192
		loop 1
		priority 15
		signal $0010
		detailLevel 3
	)
	
	(method (doVerb theVerb param2)
		(fountain doVerb: theVerb param2 &rest)
	)
)

(instance statue of Feature
	(properties
		x 95
		y 171
		z 75
		nsTop 64
		nsLeft 73
		nsBottom 129
		nsRight 117
		description {Chesty}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_10 1 90)
				(proc0_14 190 2)
			)
			(3 (proc0_14 190 3))
			(5 (proc0_14 190 4))
			(10 (proc0_14 190 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance logo of Feature
	(properties
		x 193
		y 20
		nsTop 3
		nsLeft 180
		nsBottom 37
		nsRight 207
		description {to logo PornProdCorp}
		sightAngle 40
		lookStr {Pøedpokládáš, že PPC si to logo vybrala, protože jazyk je univerzálním symbolem vytøíbené chuti.}
	)
)

(instance tree of Feature
	(properties
		x 263
		y 169
		z 100
		nsTop 4
		nsLeft 235
		nsBottom 134
		nsRight 292
		description {palma}
		sightAngle 40
		onMeCheck $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2
				(proc0_14 190 6)
				(proc0_14 190 7 67 -1 185)
			)
			(3 (proc0_14 190 8))
			(5 (proc0_14 190 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance HollywoodSign of Feature
	(properties
		x 92
		y 80
		nsBottom 46
		nsRight 61
		description {nápis Hollywood}
		sightAngle 40
		lookStr {Rád tu pracuješ, protože se tu všichni strašnì snaží, aby se k tobì chovali férovì.}
	)
)

(instance buildings1 of Feature
	(properties
		x 28
		y 92
		nsTop 71
		nsBottom 113
		nsRight 57
		description {budovy}
		sightAngle 40
		lookStr {Zajímalo by tì, kolik disko veèírkù se koná v tìch kanceláøských budovách tamhle!}
	)
)

(instance buildings2 of Feature
	(properties
		x 299
		y 87
		nsTop 69
		nsLeft 279
		nsBottom 105
		nsRight 319
		description {budovy}
		sightAngle 40
		lookStr {Zajímalo by tì, kolik disko veèírkù se koná v tìch kanceláøských budovách tamhle!}
	)
)

(instance windows1 of Feature
	(properties
		x 105
		y 106
		nsTop 97
		nsLeft 81
		nsBottom 116
		nsRight 129
		description {okna}
		sightAngle 40
		lookStr {Ty prostì miluješ šmírování, viï?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 190 10))
			(5
				(proc0_14 190 11)
				(proc0_14 190 12 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance windows2 of Feature
	(properties
		x 238
		y 100
		nsTop 89
		nsLeft 216
		nsBottom 112
		nsRight 260
		description {okna}
		sightAngle 40
		lookStr {Ty prostì miluješ šmírování, viï?}
	)
	
	(method (doVerb theVerb param2)
		(windows1 doVerb: theVerb param2 &rest)
	)
)

(instance debugFeature of Feature
	(properties
		x 29
		y 33
		nsTop 31
		nsLeft 27
		nsBottom 35
		nsRight 31
		sightAngle 40
	)
	
	(method (init)
		(gLl5MDHandler addToEnd: self)
		(super init:)
	)
	
	(method (dispose)
		(gLl5MDHandler delete: self)
		(super dispose:)
	)
	
	(method (handleEvent pEvent)
		(if
			(and
				(== (pEvent type?) evMOUSEBUTTON)
				(== gCursorNumber 1)
				(== (pEvent modifiers?) 12)
			)
			(= global111 1)
		else
			(global2 handleEvent: pEvent)
		)
	)
)
