;;; Sierra Script 1.0 - (do not remove this comment)
(script# 430)
(include sci.sh)
(use Main)
(use LLRoom)
(use RTRandCycle)
(use Polygon)
(use CueObj)
(use n958)
(use StopWalk)
(use Sound)
(use Jump)
(use Cycle)
(use PicView)
(use Obj)

(public
	rm430 0
)

(local
	[local0 8] = [175 112 246 112 246 120 175 120]
	[local8 8] = [212 112 254 112 254 120 212 120]
)
(instance rm430 of LLRoom
	(properties
		lookStr {Aèkoli jsi o tom nepøemýšlel, takhle sis laboratoø FBI nepøedstavoval.}
		picture 430
		east 440
		west 420
	)
	
	(method (init)
		(braPolygon points: @local0 size: 4)
		(braPolygon2 points: @local8 size: 4)
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
						103
						133
						103
						133
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
		)
		(proc958_0 128 430 430 432 1430)
		(Load rsSOUND 436)
		(Load rsSCRIPT 991)
		(gLarry init: edgeHit: 0 normalize:)
		(desmondDoor init:)
		(if (== gGNumber 440)
			(gLarry x: 300)
			(self style: 11 setScript: sEnter)
			(desmondDoor cue:)
		else
			(proc958_0 128 438 1431)
			(proc958_0 132 40 41)
			(gLarry x: 30 y: 105 cycleSpeed: 6 moveSpeed: 6)
			(twit init: posn: 108 104 setCycle: StopWalk -1)
			(proc0_2)
			(self setScript: sRoom)
		)
		(if (not (proc0_6 41))
			(proc958_0 132 431 432 433)
			(vibMan init: setScript: sWork)
		)
		(if (not (proc0_6 42))
			(proc958_0 132 434 435)
			(global2 addObstacle: braPolygon)
			(braMan init: stopUpd:)
			(techMan init:)
		)
		(northDoor init: stopUpd:)
		(ladder setCycle: Fwd init:)
		(dartboard init:)
		(monitors init:)
		(plug init:)
		(outlet init:)
		(chair init:)
		(joystick init:)
		(circuitboard init:)
		(northBank init:)
		(southBank init:)
		(super init:)
	)
	
	(method (dispose)
		(DisposeScript 991)
		(super dispose:)
	)
)

(instance sEnter of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(twit
					init:
					x: 400
					y: 101
					setCycle: StopWalk -1
					setMotion: MoveTo 280 101 self
				)
			)
			(1 (proc0_3) (self dispose:))
		)
	)
)

(instance sWork of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client setCycle: End)
				(= seconds (Random 2 3))
			)
			(1 (self init:))
		)
	)
)

(instance sRoom of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(twit setHeading: 270)
				(= cycles 1)
			)
			(1
				(soundFX number: 40 play:)
				(desmondDoor setCycle: End self)
			)
			(2
				(gLongSong2 number: 436 setLoop: -1 play:)
				(desmondDoor stopUpd:)
				(desmond
					init:
					x: 45
					y: 101
					setCycle: Walk
					setMotion: MoveTo 95 (desmond y?)
				)
				(gLarry setMotion: MoveTo 96 (+ (gLarry y?) 4) self)
			)
			(3 (= ticks 60))
			(4
				(proc0_18 Inspector_Desmond 430 0 108 139 self)
			)
			(5 (= seconds 3))
			(6
				(proc0_18 Commander_Twit 430 1 108 139 self)
			)
			(7 (= seconds 3))
			(8
				(proc0_18 gLarry 430 2 67 -1 185)
				(= ticks 60)
			)
			(9
				(proc0_18 Commander_Twit 430 3 108 139 self)
			)
			(10 (= ticks 60))
			(11
				(proc0_18 gLarry 430 4 67 -1 185)
				(= ticks 60)
			)
			(12
				(proc0_18 Commander_Twit 430 5 108 139 self)
			)
			(13 (= ticks 60))
			(14
				(proc0_18 Inspector_Desmond 430 6 108 139 self)
			)
			(15
				(desmond
					setMotion: MoveTo (- (desmond x?) 75) (desmond y?) self
				)
			)
			(16
				(desmond dispose:)
				(desmondDoor setCycle: Beg desmondDoor)
				(soundFX number: 41 play:)
				(twit setMotion: MoveTo 154 (- (twit y?) 3) self)
			)
			(17 (proc0_11 twit gLarry self))
			(18
				(gLarry
					moveSpeed: (gGame egoMoveSpeed?)
					cycleSpeed: (gGame egoMoveSpeed?)
				)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sVibrator of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_11 gLarry braMan self)
			)
			(1
				(proc0_18 gLarry 430 7)
				(= ticks 60)
			)
			(2
				(proc0_7 41)
				(proc0_18 Commander_Twit 430 8 108 139 self)
			)
			(3
				(soundFX number: 431 setLoop: -1 play:)
				(proc0_11 gLarry vibMan self)
			)
			(4
				(vibMan
					setScript: 0
					setLoop: 1
					cycleSpeed: 24
					setCycle: Fwd
				)
				(= ticks 180)
			)
			(5
				(vibMan
					setCel: 0
					setLoop: 2
					cycleSpeed: 18
					setCycle: End self
				)
			)
			(6
				(soundFX number: 432 play:)
				(vibMan setCel: 0 setLoop: 3 setCycle: End self)
			)
			(7
				(soundFX number: 433 play:)
				(vibMan
					x: (- (vibMan x?) 6)
					y: (- (vibMan y?) 12)
					xStep: 8
					yStep: 8
				)
				(= cycles 1)
			)
			(8
				(vibMan
					setLoop: 4
					cycleSpeed: 4
					moveSpeed: 8
					setStep: 1 1
					setCycle: Fwd
					setMotion: JumpTo -30 230 self
				)
			)
			(9
				(soundFX fade:)
				(vibMan dispose:)
				(= ticks 180)
			)
			(10
				(proc0_18 Commander_Twit 430 9 108)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance sBra of Script
	(properties)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(proc0_7 42)
				(techMan setScript: sWork)
				(proc0_11 gLarry braMan self)
			)
			(1
				(proc0_18 gLarry 430 10)
				(= ticks 60)
			)
			(2
				(proc0_18 Commander_Twit 430 11 108 139 self)
			)
			(3
				(techMan setScript: 0 setCycle: End self)
			)
			(4
				(techMan setLoop: 6 setCel: 0 setCycle: End self)
				(braMan setLoop: 1 setCel: 0)
			)
			(5
				(soundFX number: 435 setLoop: 1 play:)
				(techMan setLoop: 1 setCel: 0 setCycle: Fwd)
				(braMan setCel: 1)
				(= ticks 120)
			)
			(6
				(proc0_18 gLarry 430 12 67 -1 185)
				(= ticks 60)
			)
			(7 (proc0_11 twit gLarry self))
			(8
				(proc0_18 Commander_Twit 430 13 108 139 self)
			)
			(9
				(braMan
					setLoop: 2
					setCel: 0
					cycleSpeed: 24
					setCycle: End self
				)
			)
			(10
				(braMan setLoop: 3 setCycle: Fwd)
				(techMan
					setLoop: 2
					setCel: 255
					cycleSpeed: 24
					setCycle: Beg self
				)
			)
			(11
				(proc0_14 430 14)
				(braMan setLoop: 4 setCel: 0 setCycle: End self)
			)
			(12
				(techMan
					setLoop: 3
					setMotion: MoveTo (- (techMan x?) 30) (- (techMan y?) 10) techMan
				)
				(soundFX number: 434 setLoop: 1 play:)
				(braMan
					setLoop: 4
					setCel: 0
					cycleSpeed: 5
					setCycle: End self
				)
			)
			(13
				(soundFX number: 434 setLoop: 1 play:)
				(proc0_11 twit braMan self)
			)
			(14
				(proc0_18 Commander_Twit 430 15 108 139 self)
			)
			(15
				(braMan setLoop: 5 setCel: 0 cycleSpeed: 18)
				(= ticks 66)
			)
			(16 (braMan setCycle: End self))
			(17 (= ticks 123))
			(18
				(braMan setLoop: 6 setCel: 0 setCycle: End self)
			)
			(19 (= ticks 123))
			(20
				(braMan setLoop: 5 setCel: 0 setCycle: End)
				(= seconds 3)
			)
			(21
				(proc0_18 Commander_Twit 430 16 108)
				(braMan setCycle: Beg self)
				((global2 obstacles?) delete: braPolygon)
				(global2 addObstacle: braPolygon2)
				(proc0_3)
				(self dispose:)
			)
		)
	)
)

(instance twit of Actor
	(properties
		x 30
		y 104
		description {Komandér Twit}
		lookStr {Je dokonalým obrazem èlovìka, kterého zajímá víc vìda než vlastní image!}
		view 432
		cel 2
		signal $4000
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(not (self mover?))
				(not (global2 script?))
				(> (- (gLarry x?) (self x?)) 20)
			)
			(self setMotion: MoveTo (+ x 10) y)
		)
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 430 17))
			(5
				(cond 
					((not (proc0_6 41)) (proc0_2) (global2 setScript: sVibrator))
					((not (proc0_6 42)) (proc0_2) (global2 setScript: sBra))
					(else (proc0_18 Commander_Twit 430 18 108))
				)
			)
			(10 (proc0_14 430 19))
			(else 
				(super doVerb: theVerb param2)
			)
		)
	)
)

(instance desmond of Actor
	(properties
		x 25
		y 104
		view 438
		signal $4000
	)
)

(instance desmondDoor of Prop
	(properties
		x 15
		y 48
		description {Desmondovy dveøe}
		lookStr {Tyto dveøe vedou do kanceláøe inspektora Desmonda. V souèasné dobì jsou zamèené.}
		view 430
		loop 1
		priority 14
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 430 20))
			(5
				(proc0_18 gLarry 430 21)
				(proc0_14 430 22 67 -1 185)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
	
	(method (cue)
		(super cue:)
		(self setPri: 7 stopUpd:)
	)
)

(instance northDoor of View
	(properties
		x 106
		y 77
		description {dveøe ven}
		lookStr {Tyto dveøe vedou ven.}
		view 430
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3
				(proc0_18 Commander_Twit 430 23 108)
			)
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance vibMan of Actor
	(properties
		x 137
		y 161
		description {technik vibrátorù}
		view 434
		priority 15
		signal $4010
	)
	
	(method (doVerb)
		(proc0_10 3 99)
		(proc0_2)
		(global2 setScript: sVibrator)
	)
)

(instance braMan of Prop
	(properties
		x 225
		y 114
		description {technièka, která si navléká podprsenku}
		view 436
		priority 8
		signal $4010
	)
	
	(method (doVerb theVerb param2)
		(if (not (proc0_6 42))
			(proc0_10 3 98)
			(proc0_2)
			(global2 setScript: sBra)
		else
			(super doVerb: theVerb param2)
		)
	)
)

(instance techMan of Actor
	(properties
		x 197
		y 116
		description {podprsenkáøka}
		yStep 5
		view 437
		loop 5
		cel 3
		signal $4000
		cycleSpeed 10
		xStep 15
	)
	
	(method (doit)
		(super doit: &rest)
		(if
			(and
				(== cel 1)
				(== loop 1)
				(== (soundFX prevSignal?) -1)
			)
			(soundFX play:)
		)
	)
	
	(method (doVerb theVerb param2)
		(if (proc0_6 42)
			(proc0_14 430 24)
		else
			(braMan doVerb: theVerb param2)
		)
	)
	
	(method (cue)
		(super cue:)
		(self
			setLoop: 4
			setCel: 0
			cycleSpeed: 12
			setCycle: End
			setMotion: MoveTo x (+ y 10)
		)
	)
)

(instance ladder of Prop
	(properties
		x 159
		y 193
		description {Jakobùv žebøík}
		lookStr {Na zamyšlení: celý život jsi pøedpokládal, že Jákobovy žebøíky nemají žádný skuteèný smysl!}
		view 430
		loop 2
		priority 15
		signal $4010
		detailLevel 3
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
			(2 (proc0_14 430 25))
			(3
				(proc0_14 430 26)
				(proc0_14 430 27 67 -1 185 70 280)
			)
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
		lookStr {Tyto monitory jsou momentálnì odpojené. Když se pøed mnoha lety hojnì používaly, sloužily pouze k hraní hry "Jawbreaker!" }
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 430 28))
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
			(3 (proc0_14 430 29))
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
			(3 (proc0_14 430 30))
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
			(3 (proc0_14 430 31))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance joystick of Feature
	(properties
		x 121
		y 160
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
			(3 (proc0_14 430 32))
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
			(3 (proc0_14 430 33))
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
		lookStr {Tyto stoly jsou plné velmi drahého vìdeckého vybavení, které je placeno z tvých daní!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 430 34))
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
		lookStr {Tyto stoly jsou plné velmi drahého vìdeckého vybavení, které je placeno z tvých daní!}
	)
	
	(method (doVerb theVerb param2)
		(switch theVerb
			(3 (proc0_14 430 34))
			(else 
				(super doVerb: theVerb param2 &rest)
			)
		)
	)
)

(instance soundFX of Sound
	(properties
		flags $0001
	)
)

(instance Commander_Twit of Talker
	(properties
		nsTop 15
		nsLeft 20
		view 1430
		loop 3
		viewInPrint 1
		name "Commander Twit"
	)
	
	(method (init)
		(= bust twitBust)
		(= eyes twitEyes)
		(= mouth twitMouth)
		(super init: &rest)
	)
)

(instance twitBust of Prop
	(properties
		view 1430
		loop 1
	)
)

(instance twitEyes of Prop
	(properties
		view 1430
		loop 2
		cycleSpeed 15
	)
)

(instance twitMouth of Prop
	(properties
		nsTop 47
		nsLeft 11
		view 1430
	)
)

(instance Inspector_Desmond of Talker
	(properties
		nsTop 15
		nsLeft 15
		view 1431
		loop 3
		viewInPrint 1
		name "Inspector Desmond"
	)
	
	(method (init)
		(= bust desmondBust)
		(= mouth desmondMouth)
		(= eyes desmondEyes)
		(super init: &rest)
	)
)

(instance desmondBust of Prop
	(properties
		view 1431
		loop 1
	)
)

(instance desmondEyes of Prop
	(properties
		nsTop 27
		nsLeft 31
		view 1431
		loop 2
		cycleSpeed 50
	)
)

(instance desmondMouth of Prop
	(properties
		nsTop 36
		nsLeft 22
		view 1431
	)
)

(instance braPolygon of Polygon
	(properties
		type $0002
	)
)

(instance braPolygon2 of Polygon
	(properties
		type $0002
	)
)
