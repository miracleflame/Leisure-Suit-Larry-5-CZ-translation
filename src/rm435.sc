;;; Sierra Script 1.0 - (do not remove this comment)
(script# 435)
(include sci.sh)
(use Main)
(use LLRoom)
(use Door)
(use Polygon)
(use CueObj)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm435 0
)

(instance rm435 of LLRoom
	(properties
		lookStr {Aèkoli jsi o tom nepøemýšlel, takhle sis laboratoø FBI nepøedstavoval.}
		picture 430
		north 425
		east 445
	)
	
	(method (init)
		(gLarry init: normalize: 570)
		(switch gGNumber
			(north
				(gLarry edgeHit: 0)
				(gLongSong2 number: 436 loop: -1 play:)
			)
			(east
				(proc0_3)
				(self style: 11)
			)
			(west (gLarry edgeHit: 0))
			(else 
				(proc0_3)
				(gLarry posn: 160 160 edgeHit: 0)
			)
		)
		(northDoor init: stopUpd:)
		(if (not (gLarry has: 13))
			(hooterShooter init: stopUpd: approachVerbs: 3)
		)
		(door init:)
		(dartboard init:)
		(northBank init:)
		(southBank init:)
		(monitors init:)
		(plug init:)
		(outlet init:)
		(chair init:)
		(joystick init:)
		(circuitboard init:)
		(super init:)
		(global2
			addObstacle:
				((Polygon new:)
					type: 2
					init:
						0
						0
						116
						0
						116
						69
						116
						80
						89
						80
						9
						131
						107
						131
						111
						128
						190
						128
						190
						136
						283
						136
						294
						147
						319
						147
						319
						189
						0
						189
					yourself:
				)
				((Polygon new:)
					type: 2
					init: 124 0 319 0 319 99 138 99 138 80 124 80
					yourself:
				)
		)
	)
	
	(method (newRoom newRoomNumber)
		(if (== newRoomNumber (global2 north?))
			(gLongSong2 fade:)
		)
		(super newRoom: newRoomNumber)
	)
)

(instance sGetBra of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(gLarry
					view: 441
					setLoop: 0
					setCel: 0
					cycleSpeed: 8
					moveSpeed: 8
					setCycle: CT 2 1 self
				)
			)
			(1
				(proc0_10 6 100)
				(hooterShooter dispose:)
				(gLarry get: 13 setCycle: End self)
			)
			(2
				(gLarry normalize:)
				(= ticks 67)
			)
			(3
				(proc0_14 435 0)
				(= seconds 3)
			)
			(4
				(proc0_14 435 1 67 -1 185)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance northDoor of Door
	(properties
		x 106
		y 77
		description {dveøe ven}
		approachX 126
		approachY 85
		lookStr {Tyto dveøe vedou ven na ulici.}
		view 430
		entranceTo 425
		moveToX 120
		moveToY 75
		enterType 0
		exitType 0
	)
)

(instance hooterShooter of View
	(properties
		x 271
		y 96
		z 22
		description {podprsenkový kanón}
		sightAngle 40
		approachX 261
		approachY 99
		lookStr {Zdá se, že technik FBI nechal podprsenku ležet na pracovním stole!}
		view 430
		loop 3
		signal $4000
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_2)
				(global2 setScript: sGetBra)
			)
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance door of Feature
	(properties
		x 23
		y 80
		nsTop 47
		nsLeft 5
		nsBottom 114
		nsRight 42
		description {Desmondovy dveøe}
		sightAngle 40
		lookStr {Tyto dveøe vedou do kanceláøe inspektora Desmonda. V souèasné dobì jsou zamèené.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 2))
			(5
				(proc0_14 435 3)
				(proc0_14 435 4 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance dartboard of Feature
	(properties
		x 64
		y 91
		z 40
		nsTop 37
		nsLeft 54
		nsBottom 65
		nsRight 75
		description {šipky}
		sightAngle 40
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(2 (proc0_14 435 5))
			(3
				(proc0_14 435 6)
				(proc0_14 435 7 67 -1 185 70 280)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance northBank of Feature
	(properties
		x 234
		y 89
		z 55
		nsTop 1
		nsLeft 155
		nsBottom 77
		nsRight 319
		description {laboratorní stoly}
		sightAngle 40
		lookStr {Tyto stoly jsou plné velmi drahého vìdeckého vybavení, které bylo zaplaceno z tvých daní!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 8))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance southBank of Feature
	(properties
		x 159
		y 125
		nsTop 118
		nsBottom 189
		nsRight 319
		description {laboratorní stoly}
		sightAngle 40
		lookStr {Tyto stoly jsou plné velmi drahého vìdeckého vybavení, které bylo zaplaceno z tvých daní!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 8))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance monitors of Feature
	(properties
		x 190
		y 90
		z 49
		nsTop 24
		nsLeft 164
		nsBottom 59
		nsRight 216
		description {monitory}
		sightAngle 40
		lookStr {Tyto monitory jsou v souèasné dobì odpojeny. Když byly pøed mnoha lety hojnì využívány, sloužily pouze k hraní hry "Jawbreaker!"}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 9))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance plug of Feature
	(properties
		x 83
		y 118
		z 100
		nsTop 3
		nsLeft 71
		nsBottom 33
		nsRight 96
		description {obøí zástrèka}
		sightAngle 40
		lookStr {Zajímalo by tì, do èeho pøesnì se ta obøí zástrèka zapojuje.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 10))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance outlet of Feature
	(properties
		x 147
		y 77
		z 27
		nsTop 43
		nsLeft 142
		nsBottom 57
		nsRight 152
		description {interkom}
		sightAngle 40
		lookStr {Tento interkom používají laboratorní technici ke komunikaci s pøední kanceláøí a komandérem Twitem.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 11))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance chair of Feature
	(properties
		x 169
		y 130
		nsTop 117
		nsLeft 152
		nsBottom 144
		nsRight 186
		description {køeslo}
		sightAngle 40
		lookStr {Tato kanceláøská židle ti brání v pøístupu ke složitému vybavení pod ní.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 12))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		x 121
		y 169
		z 34
		nsTop 126
		nsLeft 108
		nsBottom 145
		nsRight 135
		description {džojstik}
		sightAngle 40
		lookStr {Páni! To je ale džojstik!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 13))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance circuitboard of Feature
	(properties
		x 68
		y 189
		z 9
		nsTop 172
		nsLeft 46
		nsBottom 189
		nsRight 91
		description {deska s obvody}
		sightAngle 40
		lookStr {Tohle vypadá jako obøí deska s plošnými spoji.}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 435 14))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)
