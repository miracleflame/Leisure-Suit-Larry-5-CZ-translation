;;; Sierra Script 1.0 - (do not remove this comment)
(script# 905)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Class_255_0)
(use RTRandCycle)
(use PolyPath)
(use Polygon)
(use CueObj)
(use Cycle)
(use InvI)
(use User)
(use PicView)
(use Obj)

(public
	rm905 0
)

(local
	local0
	local1
	local2
	local3
	local4
	local5
	local6
	local7
	local8
	local9
	local10
)
(procedure (localproc_1c82 param1)
	(if (not param1) (= param1 -1))
	(if (== ((Inv at: 22) state?) 1)
		(gLarry setLoop: param1 normalize: 908)
	else
		(gLarry setLoop: param1 normalize: 550)
	)
)

(instance rm905 of LLRoom
	(properties
		lookStr {Jsi v èekárnì Nebeské dentální hygieny doktora Vytlhala. Líbí se ti motiv koberce; vlastnì si jsi jistý, že už jsi nìco podobného nìkde vidìl...}
		picture 905
		east 910
		south 900
	)
	
	(method (init)
		(proc0_22 0)
		(proc0_13 0)
		(Load rsVIEW 907)
		(Load rsVIEW 908)
		(Load rsVIEW 906)
		(gLarry init: normalize:)
		(proc0_3)
		(switch gGNumber
			(900
				(self setScript: sEnterFromOutside)
			)
			(910 (gLarry edgeHit: 0))
			(915
				(door entranceTo: 915)
				(gLarry edgeHit: 0)
			)
			(else 
				(= global160 3)
				(gLarry posn: 172 160)
			)
		)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						319
						52
						205
						117
						199
						113
						180
						119
						171
						105
						151
						106
						69
						116
						62
						120
						63
						125
						56
						134
						48
						166
						37
						173
						38
						187
						317
						187
						274
						164
						282
						160
						263
						156
						211
						129
						231
						116
						319
						114
						319
						189
						0
						189
						0
						0
						319
						0
					yourself:
				)
		)
		(nurseWindow init: approachVerbs: 2 5 3)
		(glass init: approachVerbs: 2 5 3 stopUpd:)
		(if (not (proc0_6 4)) (girl init:))
		(phone init: approachVerbs: 3)
		(toothTable init: approachVerbs: 3 2)
		(toothTable2 init: approachVerbs: 3 2)
		(degrees init:)
		(rTable init: approachVerbs: 3)
		(lTable init: approachVerbs: 3)
		(lChair init: approachVerbs: 3)
		(rChair init:)
		(rChair2 init:)
		(pic2 init:)
		(palm init: approachVerbs: 3 2)
		(palm2 init: approachVerbs: 3 2)
		(lipPic init:)
		(magazines init: approachVerbs: 3 2 4)
		(thePhone init: approachVerbs: 3)
		(if
		(and (not (proc0_6 33)) (not (gLarry has: 22)))
			(laceDoily init: stopUpd: approachVerbs: 3)
		)
		(door init:)
		(gLongSong number: 905 setLoop: -1 play:)
	)
	
	(method (doit)
		(super doit:)
		(cond 
			(script)
			((proc0_5 gLarry 2)
				(cond 
					((== (gLarry view?) 550) (self setScript: sExitToOutside))
					((not local0) (= local0 1) (proc0_14 905 2))
				)
			)
			((proc0_5 gLarry 8) (= local0 0))
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (proc999_5 (gLarry view?) 906 907)
					(proc0_14 905 0)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(if local8
			(proc0_14 905 1)
			(= local8 0)
			(proc0_3)
		else
			(localproc_1c82 2)
		)
	)
	
	(method (notify param1)
		(= local5 param1)
	)
)

(instance magazines of Feature
	(properties
		x 54
		y 81
		nsTop 60
		nsLeft 41
		nsBottom 103
		nsRight 67
		description {èasopisy}
		sightAngle 40
		approachX 62
		approachY 120
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(4
				(switch param2
					(9
						(proc0_14 905 3)
						(gLarry put: 9)
						(proc0_7 52)
					)
					(else 
						(super doVerb: theVerb param2 &rest)
					)
				)
			)
			(2 (proc0_14 905 4))
			(3 (proc0_14 905 5))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance palm of Feature
	(properties
		x 17
		y 232
		z 100
		nsTop 75
		nsBottom 189
		nsRight 34
		description {palma}
		sightAngle 40
		onMeCheck $0004
		approachX 40
		approachY 184
		lookStr {Pøemýšlíš, jestli ta palma bude nìkdy potøebovat "koøenový kanálek"?}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 905 6))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance palm2 of Feature
	(properties
		x 184
		y 74
		nsTop 34
		nsLeft 163
		nsBottom 115
		nsRight 205
		sightAngle 40
		onMeCheck $0004
		approachX 177
		approachY 117
	)
	
	(method (doVerb)
		(palm doVerb: &rest)
	)
)

(instance lipPic of Feature
	(properties
		x 14
		y 67
		nsTop 41
		nsBottom 93
		nsRight 28
		description {malba}
		sightAngle 40
		lookStr {Vždycky jsi byl velkým fanouškem té umìlecké školy "Veselý zub".}
	)
)

(instance pic2 of Feature
	(properties
		x 277
		y 77
		nsTop 49
		nsLeft 257
		nsBottom 106
		nsRight 298
		description {malba}
		sightAngle 40
		lookStr {Vždycky jsi byl velkým fanouškem té umìlecké školy "Veselý zub".}
	)
)

(instance degrees of Feature
	(properties
		x 314
		y 84
		nsTop 59
		nsLeft 310
		nsBottom 110
		nsRight 319
		description {doktorovy diplomy}
		sightAngle 40
		lookStr {Vtipné. Nikdy jsi neslyšel o zubaøi, který se specializuje na zubaøinu typu "Provázek a klika". A kde pøesnì je "Škola tvrdého klepání"?}
	)
)

(instance toothTable of Feature
	(properties
		x 190
		y 97
		nsTop 82
		nsLeft 177
		nsBottom 113
		nsRight 203
		description {stùl}
		sightAngle 40
		approachX 177
		approachY 117
		lookStr {Mùžeš øíct, že to tu vyzdobila doktorova žena. Trpí smrtelnou roztomilostí!}
	)
)

(instance lChair of Feature
	(properties
		x 43
		y 137
		nsTop 100
		nsLeft 28
		nsBottom 134
		nsRight 59
		description {židle}
		sightAngle 40
		approachX 62
		approachY 127
		lookStr {Tahle židle vypadá tak akorát!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (global2 setScript: sChair))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance rChair of Feature
	(properties
		x 282
		y 135
		nsTop 112
		nsLeft 265
		nsBottom 159
		nsRight 300
		description {židle}
		sightAngle 40
		lookStr {Tahle židle vypadá moc tvrdì.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 905 7))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance rChair2 of Feature
	(properties
		x 246
		y 123
		nsTop 103
		nsLeft 225
		nsBottom 143
		nsRight 268
		description {židle}
		sightAngle 40
		lookStr {Tato židle vypadá pøíliš mìkce.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 905 8))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance lTable of Feature
	(properties
		x 32
		y 147
		nsTop 125
		nsLeft 15
		nsBottom 170
		nsRight 50
		description {stùl}
		sightAngle 40
		approachX 59
		approachY 129
		lookStr {Tento stùl je vybaven telefonem, který je sem umístili pro pohodlí doktorových zákazníkù.}
	)
	
	(method (doVerb)
		(phone doVerb: &rest)
	)
)

(instance rTable of Feature
	(properties
		x 301
		y 159
		nsTop 141
		nsLeft 284
		nsBottom 177
		nsRight 319
		description {stùl}
		sightAngle 40
		approachX 287
		approachY 159
	)
	
	(method (doVerb theVerb)
		(switch theVerb
			(2
				(if (gLarry has: 22)
					(proc0_14 905 9)
				else
					(proc0_14 905 10)
				)
			)
			(3
				(cond 
					((gLarry has: 22) (proc0_14 905 11))
					((proc999_5 (gLarry view?) 906 907) (global2 setScript: sChair 0 self))
					((IsObject laceDoily) (laceDoily doVerb: theVerb))
				)
			)
		)
	)
)

(instance glass of Prop
	(properties
		x 115
		y 84
		approachX 134
		approachY 109
		view 905
		priority 6
		signal $4810
	)
	
	(method (doVerb)
		(nurseWindow doVerb: &rest)
	)
)

(instance girl of Prop
	(properties
		x 138
		y 75
		description {recepèní}
		lookStr {Chvíli sis myslel, že tohle by mohla být ta koèka, kterou hledáš. Oèividnì není. Ani ty bys ji nemohl považovat za sexy (a ty víš, jak nízké nároky máš!).}
		view 909
	)
)

(instance phone of Prop
	(properties
		x 32
		y 156
		z 20
		nsTop 130
		nsLeft 24
		nsBottom 142
		nsRight 41
		description {telefon v èekárnì}
		sightAngle 40
		approachX 59
		approachY 129
		lookStr {Dlouhý stùl je vybaven telefonem, který je sem umístili pro pohodlí doktorových zákazníkù.}
		view 905
		loop 2
		signal $4810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(cond 
					((proc999_5 (gLarry view?) 906 907)
						(if (== (gLarry loop?) 3)
							(global2 setScript: sHangUp)
						else
							((global2 script?) cue:)
						)
					)
					((global2 script?) (super doVerb: theVerb param2 &rest))
					(else
						(proc0_2)
						(= local3 1)
						(gLarry view: 550)
						(global2 setScript: sChair)
					)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance Alberta of Talker
	(properties
		nsTop 33
		nsLeft 22
		view 1909
		loop 3
		viewInPrint 1
	)
	
	(method (init)
		(= bust talkerBust)
		(= eyes talkerEyes)
		(= mouth talkerMouth)
		(super init:)
	)
)

(instance talkerBust of View
	(properties
		view 1909
		loop 1
	)
)

(instance talkerEyes of Prop
	(properties
		nsTop 35
		nsLeft 34
		view 1909
		loop 2
	)
)

(instance talkerMouth of Prop
	(properties
		nsTop 44
		nsLeft 33
		view 1909
	)
)

(instance sEnterFromOutside of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					posn: 163 237
					setHeading: 0
					setMotion: MoveTo 163 179 self
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sExitToOutside of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLongSong fade:)
				(gLarry
					setMotion: MoveTo (gLarry x?) (+ (gLarry y?) 50) self
				)
			)
			(1 (global2 newRoom: 900))
		)
	)
)

(instance sHangUp of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry
					setLoop: 3
					setCel: 255
					cycleSpeed: 6
					setCycle: Beg self
				)
			)
			(1
				(gLarry setLoop: 1 setCel: 255)
				(proc0_3)
				(gUser canControl: 0)
				(gIconBar disable: 0)
				(self dispose:)
			)
		)
	)
)

(instance sChair of Script
	(properties)
	
	(method (doit)
		(super doit:)
		(if
			(and
				(== state 2)
				((User curEvent?) type?)
				((User curEvent?) message?)
				(== (gIconBar curIcon?) (gIconBar at: 0))
				(or
					(== ((User curEvent?) message?) 1)
					(& ((User curEvent?) type?) $0040)
				)
			)
			(= local7 1)
			(self init:)
		)
	)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(if (proc999_5 (gLarry view?) 906 907)
					(gLarry setLoop: 1 cycleSpeed: 6 setCycle: Beg self)
				else
					(if (not local10)
						(proc0_14 905 12 67 -1 20 108)
						(= local10 1)
					)
					(gLarry sitting: 1)
					(= state 1)
					(if (== ((Inv at: 22) state?) 1)
						(gLarry view: 907)
					else
						(gLarry view: 906)
					)
					(gLarry
						heading: 90
						setLoop: 1
						cycleSpeed: 6
						setCycle: End self
					)
					(palm approachVerbs: 0)
					(palm2 approachVerbs: 0)
					(magazines approachVerbs: 0)
					(nurseWindow approachVerbs: 0)
					(glass approachVerbs: 0)
					(laceDoily approachVerbs: 0)
					(rTable approachVerbs: 0)
					(phone approachVerbs: 0)
					(girl approachVerbs: 0)
					(door approachVerbs: 0)
				)
			)
			(1
				(palm approachVerbs: 3 2 4)
				(palm2 approachVerbs: 3 2 4)
				(magazines approachVerbs: 3 2 4)
				(nurseWindow approachVerbs: 3 5)
				(glass approachVerbs: 3 5)
				(laceDoily approachVerbs: 3)
				(rTable approachVerbs: 3)
				(phone approachVerbs: 3)
				(girl approachVerbs: 3)
				(door approachVerbs: 3 2 4)
				(localproc_1c82 0)
				(proc0_3)
				(if (IsObject register) (proc0_15 register 3))
				(if local7
					(= local7 0)
					(gLarry
						setMotion: PolyPath ((User curEvent?) x?) ((User curEvent?) y?)
					)
				)
				(= register 0)
				(gLarry sitting: 0)
				(self dispose:)
			)
			(2
				(proc0_3)
				(gUser canControl: 0)
				(= register 0)
				(if local3 (self setScript: sPhone))
			)
			(3
				(= state 1)
				(self setScript: sPhone)
				(= cycles 1)
			)
		)
	)
)

(instance sPhone of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2])
		(switch (= state newState)
			(0
				(proc0_2)
				(= local6 1)
				(if (== ((Inv at: 22) state?) 1)
					(gLarry view: 907)
				else
					(gLarry view: 906)
				)
				(gLarry
					setLoop: 3
					setCel: 0
					cycleSpeed: 6
					setCycle: End self
				)
			)
			(1
				((ScriptID 20 0) init: 1 self)
			)
			(2 (= cycles 2))
			(3
				(proc0_2)
				(switch local5
					(8544
						(proc0_14 905 13)
						(proc0_18 gLarry 905 14)
						(cond 
							((not (proc0_6 4)) (proc0_14 905 15))
							((not (proc0_6 1)) (proc0_7 1) (proc0_14 905 16))
							(else (proc0_14 905 17))
						)
					)
					(3627
						(if (not (proc0_7 18))
							(proc0_7 18)
							(if (proc0_6 4)
								(proc0_18 Alberta 905 18 108)
							else
								(proc0_14 905 19)
								(proc0_18 gLarry 905 20)
							)
						else
							(proc0_14 905 21)
						)
					)
					(-1 (proc0_14 905 22))
					(else 
						(proc0_14 905 23)
						(proc0_18 gLarry 905 24)
					)
				)
				(self setScript: sHangUp self)
			)
			(4
				(= local6 0)
				(= local3 0)
				(proc0_3)
				(gUser canControl: 0)
				(self dispose:)
			)
		)
	)
)

(instance nurseWindow of Feature
	(properties
		x 112
		y 63
		nsTop 45
		nsLeft 71
		nsBottom 82
		nsRight 153
		description {posuvné sklenìné okno}
		sightAngle 40
		approachX 134
		approachY 109
	)
	
	(method (doVerb theVerb param2)
		(cond 
			((proc999_5 theVerb 3 5)
				(cond 
					((proc999_5 (gLarry view?) 906 907)
						(if (== (gLarry loop?) 3)
							(proc0_14 905 25)
						else
							(global2 setScript: sChair 0 self)
						)
					)
					((proc0_6 4) (proc0_14 905 26))
					((and (not (proc0_6 164)) (not local1)) (global2 setScript: sWindow))
					((== ((Inv at: 22) state?) 1) (global2 setScript: sWindow))
					(else (proc0_14 905 27))
				)
			)
			((== theVerb 2) (proc0_14 905 28))
			((and (== theVerb 4) (== param2 20)) (proc0_14 905 29))
			(else (super doVerb: theVerb param2 &rest))
		)
	)
)

(instance door of Door
	(properties
		x 234
		y 115
		description {dveøe}
		sightAngle 40
		approachX 194
		approachY 120
		lookStr {Tyto dveøe vedou ke vlastním ordinacím doktora Vytlhala, vèetnì (jak doufáš) kabinky Chi Chi Lambady, ženy, za kterou jsi vážil takovou cestu, abys s ní udìlal "rozhovor".}
		view 905
		loop 3
		entranceTo 910
		locked 1
		openSnd 0
		closeSnd 0
		moveToX 250
		moveToY 108
		enterType 0
		exitType 0
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(if (proc999_5 (gLarry view?) 906 907)
					(global2 setScript: sChair 0 self)
				else
					(super doVerb: theVerb param2 &rest)
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (close)
		(super close:)
		(= local8 1)
		(proc0_17 3 2 global2)
	)
)

(instance sWindow of Script
	(properties)
	
	(method (changeState newState &tmp [temp0 2] [temp2 60])
		(switch (= state newState)
			(0
				(proc0_2)
				(if (== ((Inv at: 22) state?) 1)
					(gLarry
						view: 907
						setLoop: 0
						cycleSpeed: 6
						setCycle: End self
					)
				else
					(gLarry
						view: 906
						setLoop: 0
						cycleSpeed: 6
						setCycle: End self
					)
				)
				(= cycles 2)
			)
			(1
				(gLongSong2 number: 911 setLoop: 1 play:)
			)
			(2
				(localproc_1c82 3)
				(proc0_14 905 30 108)
				(= ticks 90)
			)
			(3
				(gLongSong2 number: 171 setLoop: -1 play:)
				(glass cycleSpeed: 12 setCycle: End self)
			)
			(4
				(gLongSong2 stop:)
				(girl setCycle: Fwd)
				(= ticks 123)
			)
			(5
				(switch (++ local9)
					(1
						(proc0_18 Alberta 905 31 108 139 self)
					)
					(else 
						(proc0_18 Alberta 905 32 108 139 self)
					)
				)
				(if (or (proc0_6 18) (== (gLarry view?) 908))
					(= state 15)
				)
			)
			(6
				(switch local9
					(1 (proc0_18 gLarry 905 33))
					(else  (proc0_18 gLarry 905 34))
				)
				(= ticks 123)
			)
			(7
				(switch local9
					(1
						(proc0_18 Alberta 905 35 108 139 self)
					)
					(else 
						(= state 9)
						(= local2 0)
						(proc0_18 Alberta 905 36 108 139 self)
					)
				)
			)
			(8
				(gLongSong2 number: 171 setLoop: -1 play:)
				(glass setCycle: Beg self)
			)
			(9
				(gLongSong2 stop:)
				(proc0_18 gLarry 905 37)
				(= start (= register 0))
				(proc0_3)
				(localproc_1c82 3)
				(self dispose:)
			)
			(10
				(if gTheNewDialog (gTheNewDialog dispose:))
				(proc0_14 905 38)
				(= ticks 123)
			)
			(11
				(proc0_18 Alberta 905 39 108 139 self)
			)
			(12
				(girl setCel: 0)
				(Format @temp2 905 40 (++ local2))
				(switch local2
					(0 0)
					(1
						(= register
							(proc255_0 905 41 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(2
						(= register
							(proc255_0 905 42 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(3
						(= register
							(proc255_0 905 43 81 {Ano} 1 81 {Ne} 0 80 @temp2)
						)
					)
					(4
						(= register
							(proc255_0 905 44 81 {Ano} 1 81 {Ne} 0 80 @temp2)
						)
					)
					(5
						(= register
							(proc255_0 905 45 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(6
						(= register
							(proc255_0 905 46 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(7
						(= register
							(proc255_0 905 47 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(8
						(= register
							(proc255_0 905 48 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(9
						(= register
							(proc255_0 905 49 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(10
						(= register
							(proc255_0 905 50 81 {Ano} 0 81 {Ne} 1 80 @temp2)
						)
					)
					(11
						(= register
							(proc255_0 905 51 81 {Ano} 1 81 {Ne} 0 80 @temp2)
						)
					)
					(12
						(= register
							(proc255_0 905 52 81 {Ano} 1 81 {Ne} 0 80 @temp2)
						)
					)
					(13
						(= register
							(proc255_0 905 53 81 {Ano} 1 81 {Ne} 0 80 @temp2)
						)
					)
					(14
						(proc0_10 13 164)
						(= state 17)
						(= local1 1)
						(proc0_18 Alberta 905 54 108 139 self)
					)
				)
				(cond 
					(register (girl setCycle: Fwd))
					((< local2 14) (-- state))
				)
				(= ticks 123)
			)
			(13
				(proc0_18 Alberta 905 55 108 139 self)
			)
			(14
				(glass cycleSpeed: 4 setCycle: Beg self)
				(gLongSong2 number: 171 setLoop: -1 play:)
			)
			(15
				(gLongSong2 stop:)
				(proc0_14 905 37)
				(= start (= register 0))
				(proc0_3)
				(localproc_1c82 3)
				(self dispose:)
			)
			(16
				(girl setCel: 0)
				(cond 
					((== (gLarry view?) 908)
						(proc0_18 gLarry 905 56)
						(proc0_10 17 162)
						(proc0_7 33)
						(proc0_18 Alberta 905 57 108 139 self)
					)
					((proc0_6 18)
						(proc0_18 gLarry 905 58)
						(proc0_10 13 163)
						(proc0_18 Alberta 905 59 108 139 self)
					)
				)
			)
			(17
				(proc0_7 4)
				(gLongSong fade: 0 5 1 1)
				(localproc_1c82 3)
				(door setPri: 8 locked: 0 open:)
			)
			(18
				(gLongSong2 number: 171 setLoop: 1 play:)
				(glass cycleSpeed: 12 setCycle: Beg)
				(proc0_3)
				(localproc_1c82 3)
				(self dispose:)
			)
		)
	)
)

(instance laceDoily of Prop
	(properties
		x 307
		y 160
		nsTop 144
		nsLeft 20
		nsBottom 157
		nsRight 37
		description {ubrousek}
		sightAngle 40
		approachX 287
		approachY 159
		view 905
		loop 1
		priority 13
		signal $6810
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 905 10))
			(3
				(cond 
					((proc999_5 (gLarry view?) 906 907) (global2 setScript: sChair 0 self))
					((not (gLarry has: 22)) (proc0_2) (global2 setScript: sGetDoily))
					(else (proc0_14 905 60))
				)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance legs of View
	(properties
		view 906
		loop 4
		priority 12
		signal $4810
	)
)

(instance thePhone of Feature
	(properties
		x 31
		y 331
		z 200
		nsTop 126
		nsLeft 25
		nsBottom 137
		nsRight 38
		description {telefon}
		sightAngle 40
		approachX 62
		approachY 127
	)
	
	(method (doVerb)
		(phone doVerb: &rest)
	)
)

(instance toothTable2 of Feature
	(properties
		x 19
		y 379
		z 200
		nsTop 170
		nsBottom 189
		nsRight 39
		description {stùl}
		sightAngle 40
		approachX 47
		approachY 183
		lookStr {Mùžeš øíct, že to tu vyzdobila doktorova žena. Trpí smrtelnou roztomilostí!}
	)
)

(instance sGetDoily of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_2)
				(gLarry setHeading: 125 self)
			)
			(1
				(legs init: posn: 287 159)
				(gLarry
					view: 906
					setLoop: 4
					setCel: 1
					cycleSpeed: 8
					posn: 286 159
					setPri: 13
					setCycle: End self
				)
			)
			(2
				(laceDoily dispose:)
				(= cycles 2)
			)
			(3
				(rTable approachVerbs: 0)
				(proc0_10 5 161)
				(legs dispose:)
				(localproc_1c82 4)
				(gLarry setPri: -1 get: 22)
				(= ticks 10)
			)
			(4 (proc0_14 905 61 108 self))
			(5 (proc0_3) (self dispose:))
		)
	)
)
